package com.service;

import java.util.List;

import com.model.Friend;

public interface FriendService {
		public  void saveFriend(Friend friend);
	    
		public void updateFriend(Friend friend);
		     
		public void deleteFriendByFriendid(int friendid);
		 
		public List<Friend> findAllFriend(); 
		     
		//public  Forum findForumByFid(int fid);
	public Friend findById(int friendid);

	public void deleteAllFriend(Friend friend);

	 public boolean isFriendExist(Friend friend);


	}


