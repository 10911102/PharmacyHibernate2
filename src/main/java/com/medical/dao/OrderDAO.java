package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.medical.pojo.Order;
@Transactional
public class OrderDAO implements IOrderDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void insert(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}
	public List<Order> getAll() {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Order", Order.class).list();
	}

	public List<Order> getAllPending() {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Order where status= :status", Order.class).setParameter("status", "Not received").list();
	}

	public Order getById(int id) {
		Session session= this.sessionFactory.getCurrentSession();
		 return  session.createQuery("from Order where id= :id", Order.class).setParameter("id", id).getSingleResult();
	}
	public void updateStatus(Order order) {
		order.setStatus("Deliverd");
		sessionFactory.getCurrentSession().update(order);
	}

	

}
