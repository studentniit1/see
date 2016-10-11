package com.dao;
/*
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository("userdao")
		public class UserdaoImpl  implements Userdao {
		@Autowired
	  SessionFactory sf;

		@Override
		public User findByUserid(int userid) {
		
			return(User) sf.getCurrentSession().get(User.class,userid);
		}

		@Override
		public void saveUser(User user) {

			sf.getCurrentSession().save(user);
		}

		@Override
		public List<User> findAllUser() {
			
			return sf.getCurrentSession().createQuery("from User").list() ;
		}

		
		@Override
		public void updateUser(User user) {
			sf.getCurrentSession().update(user);	
		}

		@Override
		public void deleteUserByUserid(int userid) {
		
			sf.getCurrentSession().delete(userid);		
		}

		@Override
		public void deleteAllUser(User user) {
			sf.getCurrentSession().delete(user);
		}
		@Override
		public boolean isUserExist(User username)
		{
			boolean isUserExist=false;
			Query q=sf.getCurrentSession().createQuery("from user where username='"+username+"'");
			List<User> user=q.list();
			int size=user.size();
			if(size==1)
			{
				isUserExist=true;
				}
			return isUserExist;
		}
			}

*/

