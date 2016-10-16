package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Userdetails;

@Repository("userdao")
		public class UserdaoImpl  implements Userdao {
		@Autowired
	  SessionFactory sf;

		@Override
		public Userdetails findByUserid(int userid) {
		
			return(Userdetails) sf.getCurrentSession().get(Userdetails.class,userid);
		}

		@Override
		public void saveUserdetails(Userdetails userdetails) {

			sf.getCurrentSession().save( userdetails);
		}

		@Override
		public List<Userdetails> findAllUserdetails() {
			
			return sf.getCurrentSession().createQuery("from Userdetails").list() ;
		}

		
		@Override
		public void updateUserdetails(Userdetails  userdetails) {
			sf.getCurrentSession().update( userdetails);	
		}

		@Override
		public void deleteUserdetailsByUserid(int userid) {
		
			sf.getCurrentSession().delete(userid);		
		}

		@Override
		public void deleteAllUserdetails(Userdetails  userdetails) {
			sf.getCurrentSession().delete( userdetails);
		}
		@Override
		public boolean isUserdetailsExist(Userdetails uname)
		{
			boolean isUserdetailsExist=false;
			Query q=sf.getCurrentSession().createQuery("from user userdetails where uname='"+uname+"'");
			List<Userdetails>  userdetails=q.list();
			int size=userdetails.size();
			if(size==1)
			{
				isUserdetailsExist=true;
				}
			return isUserdetailsExist;
		}
			}


