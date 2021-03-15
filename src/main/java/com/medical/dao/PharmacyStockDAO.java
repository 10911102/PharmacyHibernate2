package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.medical.pojo.PharmacyStock;

@Transactional
public class PharmacyStockDAO implements IPharmacyStockDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(PharmacyStock pharmacyStock) {
		sessionFactory.getCurrentSession().save(pharmacyStock);
	}
	public List<PharmacyStock> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from PharmacyStock", PharmacyStock.class).list();
	}

	public PharmacyStock getById(int medicineId) {
		Session session = this.sessionFactory.getCurrentSession();
		return  session.createQuery("from PharmacyStock where medicine_id= :id", PharmacyStock.class).setParameter("id", medicineId).getSingleResult();
	}

	public void update(PharmacyStock pharmacy) {
		// String query = "update Pharmacy set Qauntity = "+quantity+" where id
		// ="+pharmacy.getId()+" ";
		sessionFactory.getCurrentSession().update(pharmacy);
	}

}
