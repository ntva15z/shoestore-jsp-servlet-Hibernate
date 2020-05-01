package com.myweb.shoptuti.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.myweb.shoptuti.HibernateEntity.Customers;
import com.myweb.shoptuti.HibernateUtils.Utils;


public class CustomerDAO {
	public Customers insert(Customers entity) throws Exception {
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans =session.beginTransaction();
			session.persist(entity);
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
	
	public Customers update(Customers entity) throws Exception {
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
	
	public void delete(String id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Customers entity = (Customers)session.load(Customers.class, id);
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	public Customers findCustomersById(String id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Customers entity = (Customers)session.load(Customers.class, id);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Customers> findAllCustomers() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Customers> list = null;
		try {
			String hql = "FROM Customers";
			list = session.createQuery(hql).list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback(); 
			throw e;
		}
		return list;
	}
	@SuppressWarnings("rawtypes")
	public Customers checkLogin(String username)throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Customers entity = null;
		try {
			String hql = "FROM Customers WHERE CustomerId=:username";
			Query query = session.createQuery(hql).setParameter("username", username);
			trans.commit();
			entity = (Customers)query.list().get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	

	@SuppressWarnings("unchecked")
	public List<Customers> findCustomersByName(String name) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		List<Customers> list = new ArrayList<>();
		Transaction trans = session.beginTransaction();
		try {
			String hql = "FROM Customers WHERE name like :name";
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
