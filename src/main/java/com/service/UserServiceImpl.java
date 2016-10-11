package com.service;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Userdao;
import com.model.User;

@Service("userservice")
		@Transactional
		public class UserServiceImpl  implements UserService {
		 
		    @Autowired
		    private Userdao  userdao;
		     
		 
		    public void updateUser(User user) {
		    	userdao.updateUser(user);
		    }
		      
		 
		    public void deleteUserByuserid(int userid) {
		        userdao.deleteUserByUserid(userid);
		    }
		     
		    public List<User> findAllUser() {
		        return userdao.findAllUser();
		    }
		 		@Override
			public User findByUserid(int userid) {
			
				return userdao.findByUserid(userid);
			
			}

			@Override
			public void saveUser(User user) {
			
				  userdao.saveUser(user);
					 
			}


			@Override
			public void deleteAllUser(User user) {
				userdao.deleteAllUser(user);
			}
		     
			@Override
			public boolean isUserExist(User user)
			{
				boolean isUserExist=false;
				isUserExist=userdao.isUserExist(user);
				if(isUserExist==true)
				{
					isUserExist=true;
				}
				return isUserExist;
				}


			@Override
			public void deleteUserByUserid(int userid) {
				    userdao.deleteUserByUserid(userid);

			}





}
*/