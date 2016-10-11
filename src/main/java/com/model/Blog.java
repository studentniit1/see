package com.model;

import java.sql.Date;
import java.sql.Time;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;

@Entity
@Controller
public class Blog {
	@Id
	private int bid;
	private String bname;
	private Time postedtime;
	private Date posteddate;
	private String blogapproved;
	public Time getPostedtime() {
		return postedtime;
	}
	public void setPostedtime(Time postedtime) {
		this.postedtime = postedtime;
	}
	public Date getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBlogapproved() {
		return blogapproved;
	}
	public void setBlogapproved(String blogapproved) {
		this.blogapproved = blogapproved;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	

}
