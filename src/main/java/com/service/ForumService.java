package com.service;

import java.util.List;
import com.model.Forum;

public interface ForumService {
//	public Forum findForumBy( int fid);
	public  void saveForum(Forum forum);
    
	public void updateForum(Forum forum);
	     
	public void deleteForumByFid(int fid);
	 
	public List<Forum> findAllForum(); 
	     
	//public  Forum findForumByFid(int fid);
public Forum findById(int fid);

public void deleteAllForum(Forum forum);

 public boolean isForumExist(Forum forum);


}
