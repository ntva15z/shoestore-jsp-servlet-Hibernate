package com.myweb.shoptuti.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.shoptuti.HibernateEntity.Cart;
import com.myweb.shoptuti.HibernateUtils.Utils;


public class CartDAO {
	public Cart insert(Cart entity) throws Exception {
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
	
	public Cart update(Cart entity) throws Exception {
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
			Cart entity = (Cart)session.load(Cart.class, id);
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public Cart findCartById(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Cart entity = (Cart)session.load(Cart.class, id);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> findAllCarts() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Cart> list = new ArrayList<>();
		try {
			String hql = "FROM Cart";
			list = session.createQuery(hql).list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return list;
	}
	

}
