package com.service;

import java.util.List;

import com.model.Userdetails;

public interface UserService {

	  public Userdetails findByUserid(int userid);
		     
		public  void saveUserdetails(Userdetails userdetails);
		     
		public void updateUserdetails(Userdetails userdetails);
		     
		public void deleteUserdetailsByUserid(int userid);
		 
		public List<Userdetails> findAllUserdetails(); 
		     
		//public  Blog findBlogByBid(int bid);

		public void deleteAllUserdetails(Userdetails userdetails);

//		public boolean isBlogExist(Blog blog);

		public boolean isUserdetailsExist(Userdetails userdetails);

		//boolean isBlogExist(Blog blog);


		}
