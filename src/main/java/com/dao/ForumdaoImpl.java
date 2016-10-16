package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Forum;

@Repository("forumdao")
		public class ForumdaoImpl implements Forumdao {
		@Autowired
	  SessionFactory sf;

		@Override
		public Forum findById(int fid) {
		
			return(Forum) sf.getCurrentSession().get(Forum.class,fid);
		}

		@Override
		public void saveForum(Forum forum) {

			sf.getCurrentSession().save(forum);
		}

		@Override
		public List<Forum> findAllForum() {
			
			return sf.getCurrentSession().createQuery("from Forum").list() ;
		}

		@Override
		public void updateForum(Forum forum) {
			sf.getCurrentSession().update(forum);	
		}

		@Override
		public void deleteForumByFid(int fid) {
		
			sf.getCurrentSession().delete(fid);		
		}

		@Override
		public void deleteAllForum(Forum forum) {
			sf.getCurrentSession().delete(forum);

		}
		@Override
		public boolean isForumExist(Forum fname)
		{
			boolean isForumExist=false;
			Query q=sf.getCurrentSession().createQuery("from forum where fname='"+fname+"'");
			List<Forum> forum=q.list();
			int size=forum.size();
			if(size==1)
			{
				isForumExist=true;
				}
			return isForumExist;
		}
		
	}


