package com.dao;

import java.util.List;

import com.model.Forum;

public interface Forumdao {

public	List<Forum> findAllForum();

public	void deleteForumByFid(int fid);

public	Forum findById(int fid);

public	void saveForum(Forum forum);

public void updateForum(Forum forum);

public void deleteAllForum(Forum forum);

 public boolean isForumExist(Forum forum);

 //public Forum findForumByFid(int fid);

}
