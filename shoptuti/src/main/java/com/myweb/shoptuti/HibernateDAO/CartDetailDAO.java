package com.myweb.shoptuti.HibernateDAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.shoptuti.HibernateEntity.CartDetail;
import com.myweb.shoptuti.HibernateUtils.Utils;


public class CartDetailDAO {
	public CartDetail insert(CartDetail entity) throws Exception {
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
	
	public CartDetail update(CartDetail entity) throws Exception {
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
			CartDetail entity = (CartDetail)session.load(CartDetail.class, id);
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public CartDetail findCartDetailById(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			CartDetail entity = (CartDetail)session.load(CartDetail.class, id);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CartDetail> findAllCartDetail() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<CartDetail> list = new ArrayList<>();
		try {
			String hql = "FROM CartDetail";
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
