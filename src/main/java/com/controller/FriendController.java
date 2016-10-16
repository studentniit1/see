package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.model.Friend;
import com.service.FriendService;

@RestController
	public class  FriendController {
					
				 
				    @Autowired
				    FriendService friendservice;  //Service which will do all data retrieval/manipulation work
				 
				    
				    //-------------------Retrieve All friend--------------------------------------------------------
				     
				    @RequestMapping(value = "/friend/", method = RequestMethod.GET)
				    public ResponseEntity<List<Friend>> listAllFriend() {
				        List<Friend> friend = friendservice.findAllFriend();
				        if(friend.isEmpty()){
				            return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
				        }
				        return new ResponseEntity<List<Friend>>(friend, HttpStatus.OK);
				    }
				 
				 
				    
				    //-------------------Retrieve Single friend--------------------------------------------------------
				     
				    @RequestMapping(value = "/friend/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
				    public ResponseEntity<Friend> getFriend(@PathVariable("id") int id) {
				        System.out.println("Fetching Friend with id " + id);
				        Friend friend = friendservice.findById(id);
				        if (friend == null) {
				            System.out.println("Friend with id " + id + " not found");
				            return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
				        }
				        return new ResponseEntity<Friend>(friend, HttpStatus.OK);
				    }
				 
				     
				     
				    //-------------------Create a friend--------------------------------------------------------
				     
				    @RequestMapping(value = "/friend/", method = RequestMethod.POST)
				    public ResponseEntity<Void> createFriend(@RequestBody Friend friend,    UriComponentsBuilder ucBuilder) {
				        System.out.println("Creating Friend " + friend.getFriendname());
				 
				        if (friendservice.isFriendExist(friend)) {
				            System.out.println("A Friend with name " + friend.getFriendname() + " already exist");
				            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
				        }
				 
				        friendservice.saveFriend(friend);
				 
				        HttpHeaders headers = new HttpHeaders();
				        headers.setLocation(ucBuilder.path("/friend/{id}").buildAndExpand(friend.getFriendid()).toUri());
				        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
				    }
				 
				    
				     
				    //------------------- Update a friend --------------------------------------------------------
				     
				    @RequestMapping(value = "/friend/{id}", method = RequestMethod.PUT)
				    public ResponseEntity<Friend> updateFriend(@PathVariable("id") int id, @RequestBody Friend friend) {
				        System.out.println("Updating Friend " + id);
				         
				        Friend currentFriend = friendservice.findById(id);
				         
				        if (currentFriend==null) {
				            System.out.println("Friend with id " + id + " not found");
				            return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
				        }
				 
				        currentFriend.setFriendname(friend.getFriendname());
				        currentFriend.setFriendid(friend.getFriendid());
				         
				        friendservice.updateFriend(currentFriend);
				        return new ResponseEntity<Friend>(currentFriend, HttpStatus.OK);
				    }
				 
				    
				    
				    //------------------- Delete a friend--------------------------------------------------------
				     
				    @RequestMapping(value = "/friend/{id}", method = RequestMethod.DELETE)
				    public ResponseEntity<Friend> deleteFriend(@PathVariable("id") int id) {
				        System.out.println("Fetching & Deleting Friend with id " + id);
				 
				        Friend friend = friendservice.findById(id);
				        if (friend == null) {
				            System.out.println("Unable to delete.Friend with id " + id + " not found");
				            return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
				        }
				 
				        friendservice.deleteFriendByFriendid(id);
				        return new ResponseEntity<Friend>(HttpStatus.NO_CONTENT);
				    }
				 
				     
				    
				    //------------------- Delete All friend--------------------------------------------------------
				     
				    @RequestMapping(value = "/friend/", method = RequestMethod.DELETE)
				    public ResponseEntity<Friend> deleteAllFriend(Friend friend) {
				        System.out.println("Deleting All Friend");
				 
				        friendservice.deleteAllFriend(friend);
				        return new ResponseEntity<Friend>(HttpStatus.NO_CONTENT);
				    }
				 
				}
			








