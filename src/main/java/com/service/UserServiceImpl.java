package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Userdao;
import com.model.Userdetails;

@Service("userservice")
		@Transactional
		public class UserServiceImpl  implements UserService {
		 
		    @Autowired
		    private Userdao  userdao;
		     
		 
		    public void updateUserdetails(Userdetails userdetails) {
		    	userdao.updateUserdetails(userdetails);
		    }
		      
		 
		    public void deleteUserdetailsByuserid(int userid) {
		        userdao.deleteUserdetailsByUserid(userid);
		    }
		     
		    public List<Userdetails> findAllUserdetails() {
		        return userdao.findAllUserdetails();
		    }
		 		@Override
			public Userdetails findByUserid(int userid) {
			
				return userdao.findByUserid(userid);
			
			}

			@Override
			public void saveUserdetails(Userdetails userdetails) {
			
				  userdao.saveUserdetails( userdetails);
					 
			}


			@Override
			public void deleteAllUserdetails(Userdetails  userdetails) {
				userdao.deleteAllUserdetails( userdetails);
			}
		     
			@Override
			public boolean isUserdetailsExist(Userdetails  userdetails)
			{
				boolean isUserdetailsExist=false;
				isUserdetailsExist=userdao.isUserdetailsExist( userdetails);
				if(isUserdetailsExist==true)
				{
					isUserdetailsExist=true;
				}
				return isUserdetailsExist;
				}


			@Override
			public void deleteUserdetailsByUserid(int userid) {
				    userdao.deleteUserdetailsByUserid(userid);

			}





}
