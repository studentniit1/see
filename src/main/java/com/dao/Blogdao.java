package com.dao;

import java.util.List;

import com.model.Blog;

public interface Blogdao {

	 
	  public Blog findById(int bid);
	 
	 public void saveBlog(Blog blog);	     
	 public List<Blog> findAllBlog();
	 
	 //public Blog findBlogByBid(int bid);

	public void updateBlog(Blog blog);

	public void deleteBlogByBid(int bid);

	public void deleteAllBlog(Blog blog);

	public boolean isBlogExist(Blog blog);

	
	 
	}
	
