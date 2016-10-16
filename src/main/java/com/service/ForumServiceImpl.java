package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Forumdao;
import com.model.Forum;

@Service("forumservice")
		@Transactional
		public class ForumServiceImpl  implements ForumService {
		 
		    @Autowired
		    private Forumdao  forumdao;

			
			@Override
			public void saveForum(Forum forum) {
				  forumdao.saveForum(forum);

				
			}

			@Override
			public void updateForum(Forum forum) {
				forumdao.updateForum(forum);

			}

			@Override
			public void deleteForumByFid(int fid) {
		        forumdao.deleteForumByFid(fid);

				
			}

			@Override
			public List<Forum> findAllForum() {
		        return forumdao.findAllForum();

				
			}

			@Override
			public Forum findById(int fid) {
				return forumdao.findById(fid);

		
			}

			@Override
			public void deleteAllForum(Forum forum) {
				forumdao.deleteAllForum(forum);

				
			}

			@Override
			public boolean isForumExist (Forum forum)
			{
				boolean isForumExist=false;
				isForumExist=forumdao.isForumExist(forum);
				if(isForumExist==true)
				{
					isForumExist=true;
				}
				return isForumExist;
				}
 
		 
				}




