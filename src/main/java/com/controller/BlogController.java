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

import com.model.Blog;
import com.service.BlogService;

@RestController


public class BlogController {
	
	 
	    @Autowired
	    BlogService blogservice;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All blog--------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
	    public ResponseEntity<List<Blog>> listAllBlog() {
	        List<Blog> blogs = blogservice.findAllBlog();
	        if(blogs.isEmpty()){
	            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single blog--------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
	        System.out.println("Fetching User with id " + id);
	        Blog blog = blogservice.findById(id);
	        if (blog == null) {
	            System.out.println("Blog with id " + id + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a blog--------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createBlog(@RequestBody Blog blog,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Blog " + blog.getBname());
	 
	        if (blogservice.isBlogExist(blog)) {
	            System.out.println("A Blog with name " + blog.getBname() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        blogservice.saveBlog(blog);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getBid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a blog --------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Blog> updateBlog(@PathVariable("id") int id, @RequestBody Blog blog) {
	        System.out.println("Updating Blog " + id);
	         
	        Blog currentBlog = blogservice.findById(id);
	         
	        if (currentBlog==null) {
	            System.out.println("Blog with id " + id + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentBlog.setBname(blog.getBname());
	        currentBlog.setBid(blog.getBid());
	        currentBlog.setBlogapproved(blog.getBlogapproved());
	         
	        blogservice.updateBlog(currentBlog);
	        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Blog> deleteUser(@PathVariable("id") int id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        Blog blog = blogservice.findById(id);
	        if (blog == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	 
	        blogservice.deleteBlogByBid(id);
	        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All blog --------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/", method = RequestMethod.DELETE)
	    public ResponseEntity<Blog> deleteAllBlog(Blog blog) {
	        System.out.println("Deleting All Blog");
	 
	        blogservice.deleteAllBlog(blog);
	        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	    }
	 
	}

