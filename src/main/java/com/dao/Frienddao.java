package com.dao;

import java.util.List;

import com.model.Friend;

public interface Frienddao {

	public	List<Friend> findAllFriend();

	public	void deleteFriendByFriendid(int friendid);

	public	Friend findById(int friendid);

	public	void saveFriend(Friend friend);

	public void updateFriend(Friend friend);

	public void deleteAllFriend(Friend friend);

	 public boolean isFriendExist(Friend friend);

	 //public Forum findForumByFid(int fid);

	}


