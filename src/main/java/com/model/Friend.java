package com.model;

import javax.persistence.Id;

public class Friend {
	@Id
private int friendid;
private String friendname;
public int getFriendid() {
	return friendid;
}
public void setFriendid(int friendid) {
	this.friendid = friendid;
}
public String getFriendname() {
	return friendname;
}
public void setFriendname(String friendname) {
	this.friendname = friendname;
}


}
