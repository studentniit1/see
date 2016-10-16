package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Jobdao;
import com.model.Job;

@Service("jobservice")
			@Transactional
			public class JobServiceImpl  implements JobService {
			 
			    @Autowired
			    private Jobdao  jobdao;

				
				@Override
				public void saveJob(Job job) {
					jobdao.saveJob(job);

					
				}

				@Override
				public void updateJob(Job job) {
					jobdao.updateJob(job);

				}

				@Override
				public void deleteJobByjobid(int jobid) {
					jobdao.deleteJobByjobid(jobid);

					
				}

				@Override
				public List<Job> findAllJob() {
			        return jobdao.findAllJob();

					
				}

				@Override
				public Job findById(int jobid) {
					return jobdao.findById(jobid);

			
				}

				@Override
				public void deleteAllJob(Job job) {
					jobdao.deleteAllJob(job);

					
				}

				@Override
				public boolean isJobExist (Job job)
				{
					boolean isJobExist=false;
					isJobExist=jobdao.isJobExist(job);
					if(isJobExist==true)
					{
						isJobExist=true;
					}
					return isJobExist;
					}
	 
			 
					}






