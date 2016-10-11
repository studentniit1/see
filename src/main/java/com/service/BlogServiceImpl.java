package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Blogdao;
import com.model.Blog;

@Service("blogservice")
	@Transactional
	public class BlogServiceImpl  implements BlogService {
	 
	    @Autowired
	    private Blogdao  blogdao;
	     
	 
	    public void updateBlog(Blog blog) {
	    	blogdao.updateBlog(blog);
	    }
	      
	 
	    public void deleteBlogByBid(int bid) {
	        blogdao.deleteBlogByBid(bid);
	    }
	     
	    public List<Blog> findAllBlog() {
	        return blogdao.findAllBlog();
	    }
	 		@Override
		public Blog findById(int bid) {
		
			return blogdao.findById(bid);
		
		}

		@Override
		public void saveBlog(Blog blog) {
		
			  blogdao.saveBlog(blog);
				 
		}


		@Override
		public void deleteAllBlog(Blog blog) {
			blogdao.deleteAllBlog(blog);
		}
	     
		@Override
		public boolean isBlogExist (Blog blog)
		{
			boolean isBlogExist=false;
			isBlogExist=blogdao.isBlogExist(blog);
			if(isBlogExist==true)
			{
				isBlogExist=true;
			}
			return isBlogExist;
			}
		}
	



