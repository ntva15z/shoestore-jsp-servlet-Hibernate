package com.myweb.shoptuti.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.shoptuti.HibernateEntity.Category;
import com.myweb.shoptuti.HibernateUtils.Utils;


public class CategoryDAO {
	public Category insert(Category entity) throws Exception {
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.persist(entity);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public Category update(Category entity) throws Exception {
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.saveOrUpdate(entity);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public void delete(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Category entity = (Category)session.load(Category.class, id);
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	public Category findCategoryById(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Category entity = (Category)session.load(Category.class, id);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategories() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Category> list = new ArrayList<>();
		try {
			String hql = "FROM Category";
			list = session.createQuery(hql).list();
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findCategoriesByName(String name) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Category> list = new ArrayList<>();
		try {
			String hql = "FROM Category WHERE name like :name";
			list = session.createQuery(hql).setParameter("name", name).list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return list;
	}
}
