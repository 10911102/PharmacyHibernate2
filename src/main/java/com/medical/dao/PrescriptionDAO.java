package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.medical.pojo.Prescription;
@Transactional
public class PrescriptionDAO implements IPrescriptionDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insert(Prescription prescription) {
		sessionFactory.getCurrentSession().save(prescription);
	}
	
	public void update(Prescription prescription) {
		sessionFactory.getCurrentSession().save(prescription);
	}
	
	public List<Prescription> getAll() {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Prescription", Prescription.class).list();
	}

	public Prescription getById(int medicineId) {
		Session session= this.sessionFactory.getCurrentSession();
		 return  session.createQuery("from Prescription where id= :id", Prescription.class).setParameter("id", medicineId).getSingleResult();
	}

	

}
