package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Blog;

@Repository("blogdao")
	public class BlogdaoImpl  implements Blogdao {
	@Autowired
  SessionFactory sf;

	@Override
	public Blog findById(int bid) {
	
		return(Blog) sf.getCurrentSession().get(Blog.class,bid);
	}

	@Override
	public void saveBlog(Blog blog) {

		sf.getCurrentSession().save(blog);
	}

	@Override
	public List<Blog> findAllBlog() {
		
		return sf.getCurrentSession().createQuery("from Blog").list() ;
	}

	
	@Override
	public void updateBlog(Blog blog) {
		sf.getCurrentSession().update(blog);	
	}

	@Override
	public void deleteBlogByBid(int bid) {
	
		sf.getCurrentSession().delete(bid);		
	}

	@Override
	public void deleteAllBlog(Blog blog) {
		sf.getCurrentSession().delete(blog);
	}
	@Override
	public boolean isBlogExist(Blog bname)
	{
		boolean isBlogExist=false;
		Query q=sf.getCurrentSession().createQuery("from blog where bname='"+bname+"'");
		List<Blog> blog=q.list();
		int size=blog.size();
		if(size==1)
		{
			isBlogExist=true;
			}
		return isBlogExist;
	}
		}

