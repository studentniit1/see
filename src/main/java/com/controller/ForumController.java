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

import com.model.Forum;
import com.service.ForumService;

@RestController
public class ForumController {
				
			 
			    @Autowired
			    ForumService forumservice;  //Service which will do all data retrieval/manipulation work
			 
			    
			    //-------------------Retrieve All forums--------------------------------------------------------
			     
			    @RequestMapping(value = "/forum/", method = RequestMethod.GET)
			    public ResponseEntity<List<Forum>> listAllForum() {
			        List<Forum> forum = forumservice.findAllForum();
			        if(forum.isEmpty()){
			            return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			        }
			        return new ResponseEntity<List<Forum>>(forum, HttpStatus.OK);
			    }
			 
			 
			    
			    //-------------------Retrieve Single forum--------------------------------------------------------
			     
			    @RequestMapping(value = "/forum/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			    public ResponseEntity<Forum> getForum(@PathVariable("id") int id) {
			        System.out.println("Fetching User with id " + id);
			        Forum forum = forumservice.findById(id);
			        if (forum == null) {
			            System.out.println("Forum with id " + id + " not found");
			            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
			        }
			        return new ResponseEntity<Forum>(forum, HttpStatus.OK);
			    }
			 
			     
			     
			    //-------------------Create a forum--------------------------------------------------------
			     
			    @RequestMapping(value = "/forum/", method = RequestMethod.POST)
			    public ResponseEntity<Void> createForum(@RequestBody Forum forum,    UriComponentsBuilder ucBuilder) {
			        System.out.println("Creating Forum " + forum.getFname());
			 
			        if (forumservice.isForumExist(forum)) {
			            System.out.println("A Forum with name " + forum.getFname() + " already exist");
			            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			        }
			 
			        forumservice.saveForum(forum);
			 
			        HttpHeaders headers = new HttpHeaders();
			        headers.setLocation(ucBuilder.path("/forum/{id}").buildAndExpand(forum.getFid()).toUri());
			        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			    }
			 
			    
			     
			    //------------------- Update a forum --------------------------------------------------------
			     
			    @RequestMapping(value = "/forum/{id}", method = RequestMethod.PUT)
			    public ResponseEntity<Forum> updateForum(@PathVariable("id") int id, @RequestBody Forum forum) {
			        System.out.println("Updating Forum " + id);
			         
			        Forum currentForum = forumservice.findById(id);
			         
			        if (currentForum==null) {
			            System.out.println("User with id " + id + " not found");
			            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
			        }
			 
			        currentForum.setFname(forum.getFname());
			        currentForum.setCommentid(forum.getCommentid());
			        currentForum.setForumapproved(forum.getForumapproved());
			         
			        forumservice.updateForum(currentForum);
			        return new ResponseEntity<Forum>(currentForum, HttpStatus.OK);
			    }
			 
			    
			    
			    //------------------- Delete a Forum--------------------------------------------------------
			     
			    @RequestMapping(value = "/forum/{id}", method = RequestMethod.DELETE)
			    public ResponseEntity<Forum> deleteForum(@PathVariable("id") int id) {
			        System.out.println("Fetching & Deleting User with id " + id);
			 
			        Forum forum = forumservice.findById(id);
			        if (forum == null) {
			            System.out.println("Unable to delete. Forum with id " + id + " not found");
			            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
			        }
			 
			        forumservice.deleteForumByFid(id);
			        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
			    }
			 
			     
			    
			    //------------------- Delete All forums --------------------------------------------------------
			     
			    @RequestMapping(value = "/forum/", method = RequestMethod.DELETE)
			    public ResponseEntity<Forum> deleteAllForum(Forum forum) {
			        System.out.println("Deleting All Forum");
			 
			        forumservice.deleteAllForum(forum);
			        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
			    }
			 
			}
		





