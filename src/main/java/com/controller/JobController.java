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

import com.model.Job;
import com.service.JobService;

@RestController
public class JobController {
						
					 
					    @Autowired
					    JobService  jobservice;  //Service which will do all data retrieval/manipulation work
					 
					    
					    //-------------------Retrieve All job--------------------------------------------------------
					     
					    @RequestMapping(value = "/ job/", method = RequestMethod.GET)
					    public ResponseEntity<List< Job>> listAllJob() {
					        List<Job> job = jobservice.findAllJob();
					        if(job.isEmpty()){
					            return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
					        }
					        return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
					    }
					 
					 
					    
					    //-------------------Retrieve Single job--------------------------------------------------------
					     
					    @RequestMapping(value = "/job/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
					    public ResponseEntity<Job> getJob(@PathVariable("id") int id) {
					        System.out.println("Fetching Friend with id " + id);
					        Job job = jobservice.findById(id);
					        if (job == null) {
					            System.out.println("Job with id " + id + " not found");
					            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
					        }
					        return new ResponseEntity<Job>(job, HttpStatus.OK);
					    }
					 
					     
					     
					    //-------------------Create a job--------------------------------------------------------
					     
					    @RequestMapping(value = "/job/", method = RequestMethod.POST)
					    public ResponseEntity<Void> createJob(@RequestBody Job job,    UriComponentsBuilder ucBuilder) {
					        System.out.println("Creating Job " + job.getJobname());
					 
					        if (jobservice.isJobExist(job)) {
					            System.out.println("A Job with name " + job.getJobname() + " already exist");
					            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
					        }
					 
					        jobservice.saveJob(job);
					 
					        HttpHeaders headers = new HttpHeaders();
					        headers.setLocation(ucBuilder.path("/job/{id}").buildAndExpand(job.getJobid()).toUri());
					        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
					    }
					 
					    
					     
					    //------------------- Update a job --------------------------------------------------------
					     
					    @RequestMapping(value = "/job/{id}", method = RequestMethod.PUT)
					    public ResponseEntity<Job> updateJob(@PathVariable("id") int id, @RequestBody Job job) {
					        System.out.println("Updating Job " + id);
					         
					        Job currentJob = jobservice.findById(id);
					         
					        if (currentJob==null) {
					            System.out.println("Job with id " + id + " not found");
					            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
					        }
					 
					        currentJob.setJobname(job.getJobname());
					        currentJob.setJobid(job.getJobid());
					         
					        jobservice.updateJob(currentJob);
					        return new ResponseEntity<Job>(currentJob, HttpStatus.OK);
					    }
					 
					    
					    
					    //------------------- Delete a job--------------------------------------------------------
					     
					    @RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
					    public ResponseEntity<Job> deleteJob(@PathVariable("id") int id) {
					        System.out.println("Fetching & Deleting Job with id " + id);
					 
					        Job job = jobservice.findById(id);
					        if (job == null) {
					            System.out.println("Unable to delete.Job with id " + id + " not found");
					            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
					        }
					 
					        jobservice.deleteJobByjobid(id);
					        return new ResponseEntity<Job>(HttpStatus.NO_CONTENT);
					    }
					 
					     
					    
					    //------------------- Delete All job--------------------------------------------------------
					     
					    @RequestMapping(value = "/job/", method = RequestMethod.DELETE)
					    public ResponseEntity<Job> deleteAllJob(Job job) {
					        System.out.println("Deleting All Job");
					 
					        jobservice.deleteAllJob(job);
					        return new ResponseEntity<Job>(HttpStatus.NO_CONTENT);
					    }
					 
					}
				









