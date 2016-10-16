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

import com.model.Userdetails;
import com.service.UserService;

@RestController

public class UserController {
			
		 
		    @Autowired
		    UserService userservice;  //Service which will do all data retrieval/manipulation work
		 
		    
		    //-------------------Retrieve All Users--------------------------------------------------------
		     
		    @RequestMapping(value = "/userdetails/", method = RequestMethod.GET)
		    public ResponseEntity<List<Userdetails>> listAllUserdetails() {
		        List<Userdetails>  userdetails = userservice.findAllUserdetails();
		        if(userdetails.isEmpty()){
		            return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<List<Userdetails>>(userdetails, HttpStatus.OK);
		    }
		 
		 
		    
		    //-------------------Retrieve Single User--------------------------------------------------------
		     
		    @RequestMapping(value = "/ userdetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<Userdetails> getUserdetails(@PathVariable("id") int id) {
		        System.out.println("Fetching Userdetails with id " + id);
		        Userdetails userdetails = userservice.findByUserid(id);
		        if ( userdetails == null) {
		            System.out.println("Userdetails with id " + id + " not found");
		            return new ResponseEntity<Userdetails>(HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<Userdetails>( userdetails, HttpStatus.OK);
		    }
		 
		     
		     
		    //-------------------Create a User--------------------------------------------------------
		     
		    @RequestMapping(value = "/userdetails/", method = RequestMethod.POST)
		    public ResponseEntity<Void> createUserdetails(@RequestBody Userdetails  userdetails,    UriComponentsBuilder ucBuilder) {
		        System.out.println("Creating Userdetails " +  userdetails.getUname());
		 
		        if (userservice.isUserdetailsExist( userdetails)) {
		            System.out.println("A Userdetails with name " + userdetails.getUname() + " already exist");
		            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		        }
		 
		        userservice.saveUserdetails( userdetails);
		 
		        HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(ucBuilder.path("/userdetails/{id}").buildAndExpand( userdetails.getUserid()).toUri());
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		    }
		 
		    
		     
		    //------------------- Update a User --------------------------------------------------------
		     
		    @RequestMapping(value = "/ userdetails/{id}", method = RequestMethod.PUT)
		    public ResponseEntity<Userdetails> updateUserdetails(@PathVariable("id") int id, @RequestBody Userdetails  userdetails) {
		        System.out.println("Updating Userdetails " + id);
		         
		        Userdetails currentUserdetails = userservice.findByUserid(id);
		         
		        if (currentUserdetails==null) {
		            System.out.println("Userdetails with id " + id + " not found");
		            return new ResponseEntity<Userdetails>(HttpStatus.NOT_FOUND);
		        }
		 
		        currentUserdetails.setUname(userdetails.getUname());
		        currentUserdetails.setPwd(userdetails.getPwd());
		        currentUserdetails.setMail(userdetails.getMail());
		         
		        userservice.updateUserdetails(currentUserdetails);
		        return new ResponseEntity<Userdetails>(currentUserdetails, HttpStatus.OK);
		    }
		 
		    
		    
		    //------------------- Delete a User --------------------------------------------------------
		     
		    @RequestMapping(value = "/ userdetails/{id}", method = RequestMethod.DELETE)
		    public ResponseEntity<Userdetails> deleteUserdetails(@PathVariable("id") int id) {
		        System.out.println("Fetching & Deleting Userdetails with id " + id);
		 
		        Userdetails userdetails = userservice.findByUserid(id);
		        if ( userdetails == null) {
		            System.out.println("Unable to delete. Userdetails with id " + id + " not found");
		            return new ResponseEntity<Userdetails>(HttpStatus.NOT_FOUND);
		        }
		 
		        userservice.deleteUserdetailsByUserid(id);
		        return new ResponseEntity<Userdetails>(HttpStatus.NO_CONTENT);
		    }
		 
		     
		    
		    //------------------- Delete All Users --------------------------------------------------------
		     
		    @RequestMapping(value = "/userdetails/", method = RequestMethod.DELETE)
		    public ResponseEntity<Userdetails> deleteAllUserdetails(Userdetails  userdetails) {
		        System.out.println("Deleting All Userdetails");
		 
		        userservice.deleteAllUserdetails( userdetails);
		        return new ResponseEntity<Userdetails>(HttpStatus.NO_CONTENT);
		    }
		 
		}
	



