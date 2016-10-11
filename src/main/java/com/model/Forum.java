package com.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;

@Entity
@Controller
public class Forum {
@Id
	private int fid;
	private String fname;
	 private Date postedtime;
	private Time posteddate;
	private String commentid;
	private String forumapproved;
	private int rating;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getForumapproved() {
		return forumapproved;
	}
	public Date getPostedtime() {
		return postedtime;
	}
	public void setPostedtime(Date postedtime) {
		this.postedtime = postedtime;
	}
	public Time getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(Time posteddate) {
		this.posteddate = posteddate;
	}
	public void setForumapproved(String forumapproved) {
		this.forumapproved = forumapproved;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
