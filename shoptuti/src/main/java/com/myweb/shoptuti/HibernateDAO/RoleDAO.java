package com.myweb.shoptuti.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.shoptuti.HibernateEntity.Role;
import com.myweb.shoptuti.HibernateUtils.Utils;

public class RoleDAO {
	public Role insert(Role entity) throws Exception{
		Session session = Utils.getSessionFactory().openSession();
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
	
	public Role update(Role entity) throws Exception{
		Session session = Utils.getSessionFactory().openSession();
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
	
	public Role delete(int id) throws Exception{
		Session session = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Role entity = (Role)session.load(Role.class, id);
			session.delete(entity);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public Role findRoleById(int id) throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			Role entity = (Role)session.load(Role.class, id);
			trans.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> findAllCustomers() throws Exception{
		Session session  = Utils.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<Role> list = new ArrayList<>();
		try {
			String hql = "FROM Role";
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
