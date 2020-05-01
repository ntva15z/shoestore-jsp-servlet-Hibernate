package com.myweb.shoptuti.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.myweb.shoptuti.HibernateEntity.Product;
import com.myweb.shoptuti.HibernateUtils.Utils;

public class ProductDAO {
	public Product insert(Product entity) throws Exception {
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
	
	public Product update(Product entity) throws Exception {
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
		}finally {
			session.close();
		}
		
	}
	
	public void delete(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		
		Transaction trans = session.beginTransaction();
		
		try {
			Product entity = (Product)session.load(Product.class, id);
			
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	public Product findProductById(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Product entity = (Product)session.load(Product.class, id);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Product> list = new ArrayList<>();
		try {
			String hql = "FROM Product";
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
	public List<Product> listResultProducts(Integer offset,Integer limit) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Product> list = new ArrayList<>();
		try {
			String hql = "FROM Product";
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			list = query.list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByName(String name) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		List<Product> list = new ArrayList<>();
		Transaction trans = session.beginTransaction();
		try {
			String hql = "FROM Product WHERE name like :name";
			list = session.createQuery(hql).setParameter("name", name).list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findProductsOrderByDesc() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Product> list = new ArrayList<>();
		try {
			String hql = "FROM Product ORDER BY price DESC";
			list = session.createQuery(hql).setMaxResults(6).list();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return list;
	}
}
