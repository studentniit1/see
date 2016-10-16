package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Job;

@Repository("jobdao")
		public class JobdaoImpl  implements Jobdao {
		@Autowired
	  SessionFactory sf;

		@Override
		public Job findById(int jobid) {
		
			return(Job) sf.getCurrentSession().get(Job.class,jobid);
		}

		@Override
		public void saveJob(Job job) {

			sf.getCurrentSession().save( job);
		}

		@Override
		public List<Job> findAllJob() {
			
			return sf.getCurrentSession().createQuery("from Job").list() ;
		}

		
		@Override
		public void updateJob(Job job) {
			sf.getCurrentSession().update(job);	
		}

		@Override
		public void deleteJobByjobid(int jobid) {
		
			sf.getCurrentSession().delete(jobid);		
		}

		@Override
		public void deleteAllJob(Job  job) {
			sf.getCurrentSession().delete( job);
		}
		@Override
		public boolean isJobExist(Job jobname)
		{
			boolean isJobExist=false;
			Query q=sf.getCurrentSession().createQuery("from job where jobname='"+jobname+"'");
			List<Job> job=q.list();
			int size=job.size();
			if(size==1)
			{
				isJobExist=true;
				}
			return isJobExist;
		}
			}


