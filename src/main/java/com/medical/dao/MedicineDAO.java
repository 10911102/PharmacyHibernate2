package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.medical.pojo.Medicine;

@Transactional
public class MedicineDAO implements IMedicineDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insert(Medicine medicine) {
		sessionFactory.getCurrentSession().save(medicine);
	}

	public List<Medicine> getAll() {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Medicine", Medicine.class).list();
	}

	public Medicine getById(int medicineId) {
		Session session= this.sessionFactory.getCurrentSession();
		 return   session.createQuery("from Medicine where id= :id", Medicine.class).setParameter("id", medicineId).getSingleResult();
	}
	public List<Medicine> getByName(String name) {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Medicine where name like concat('%', :name,'%')", Medicine.class).setParameter("name", name).list();
	}
	public List<Medicine> getByBrand(String brand) {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Medicine where brand like concat('%', :brand,'%')", Medicine.class).setParameter("brand", brand).list();
	}

}
