
package com.dao;

import java.util.List;

import com.model.Job;


public interface Jobdao {
	  public Job findById(int jobid);
		 
	 public void saveJob(Job  job);	     
	 public List<Job> findAllJob();
	 
	 //public User findUserByBid(int bid);

	public void updateJob(Job  job);

	public void deleteJobByjobid(int jobid);

	public void deleteAllJob(Job  job);

	public boolean isJobExist(Job  job);

	
	 
	}


