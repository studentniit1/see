package com.dao;

import java.util.List;

import com.model.Userdetails;

public interface Userdao {
	
		 
		  public Userdetails findByUserid(int userid);
		 
		 public void saveUserdetails(Userdetails  userdetails);	     
		 public List<Userdetails> findAllUserdetails();
		 
		 //public User findUserByBid(int bid);

		public void updateUserdetails(Userdetails  userdetails);

		public void deleteUserdetailsByUserid(int userid);

		public void deleteAllUserdetails(Userdetails  userdetails);

		public boolean isUserdetailsExist(Userdetails  userdetails);

		
		 
		}
		


