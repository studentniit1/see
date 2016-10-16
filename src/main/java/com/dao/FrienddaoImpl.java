package com.dao;


	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	import com.model.Friend;

	@Repository("frienddao")
			public class FrienddaoImpl  implements Frienddao {
			@Autowired
		  SessionFactory sf;

			@Override
			public Friend findById(int friendid) {
			
				return(Friend) sf.getCurrentSession().get(Friend.class,friendid);
			}

			@Override
			public void saveFriend(Friend friend) {

				sf.getCurrentSession().save(friend);
			}

			@Override
			public List<Friend> findAllFriend() {
				
				return sf.getCurrentSession().createQuery("from Friend").list() ;
			}

			
			@Override
			public void updateFriend(Friend friend) {
				sf.getCurrentSession().update(friend);	
			}

			@Override
			public void deleteFriendByFriendid(int friendid) {
			
				sf.getCurrentSession().delete(friendid);		
			}

			@Override
			public void deleteAllFriend(Friend  friend) {
				sf.getCurrentSession().delete( friend);
			}
			@Override
			public boolean isFriendExist(Friend friendname)
			{
				boolean isFriendExist=false;
				Query q=sf.getCurrentSession().createQuery("from friend where friendname='"+friendname+"'");
				List<Friend> friend=q.list();
				int size=friend.size();
				if(size==1)
				{
					isFriendExist=true;
					}
				return isFriendExist;
			}
				}




