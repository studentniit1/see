package com.service;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.dao.Frienddao;
import com.model.Friend;

	@Service("jobservice")
				@Transactional
				public class FriendServiceImpl  implements FriendService {
				 
				    @Autowired
				    private Frienddao  frienddao;

					
					@Override
					public void saveFriend(Friend friend) {
						frienddao.saveFriend(friend);

						
					}

					@Override
					public void updateFriend(Friend friend) {
						frienddao.updateFriend(friend);

					}

					@Override
					public void deleteFriendByFriendid(int friendid) {
						frienddao.deleteFriendByFriendid(friendid);

						
					}

					@Override
					public List<Friend> findAllFriend() {
				        return frienddao.findAllFriend();

						
					}

					@Override
					public Friend findById(int friendid) {
						return frienddao.findById(friendid);

				
					}

					@Override
					public void deleteAllFriend(Friend friend) {
						frienddao.deleteAllFriend(friend);

						
					}

					@Override
					public boolean isFriendExist (Friend friend)
					{
						boolean isFriendExist=false;
						isFriendExist=frienddao.isFriendExist(friend);
						if(isFriendExist==true)
						{
							isFriendExist=true;
						}
						return isFriendExist;
						}
		 
				 
						}








