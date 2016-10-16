package com.service;

import java.util.List;

import com.model.Job;

public interface JobService {
//		public Forum findForumBy( int fid);
		public  void saveJob(Job job);
	    
		public void updateJob(Job job);
		     
		public void deleteJobByjobid(int jobid);
		 
		public List<Job> findAllJob(); 
		     
		//public  Forum findForumByFid(int fid);
	public Job findById(int jobid);

	public void deleteAllJob(Job job);

	 public boolean isJobExist(Job job);

	


	}



