package com.medical.dao;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.medical.pojo.Doctor;

//@Component("doctorDAO")
@Transactional
public class DoctorDAO  implements IDoctorDAO{
	/*
	 * @Autowired
	 * 
	 * @Qualifier("sessionFactory")
	 */
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Doctor> getAll() throws SQLException {
		 Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Doctor", Doctor.class).list();
		 
	}


	/*
	 * public List<Doctor> searchName(String name) { String query =
	 * "select * from doctor where fname like '%"+name+"%' or lname like '%"+name+
	 * "%'"; List<Doctor> doctors = hibernateTemplate.query(query, new
	 * DoctorMapper()); return doctors; }
	 */
	public List<Doctor> searchByFName(String name) {
		Session session= this.sessionFactory.getCurrentSession();
		 return session.createQuery("from Doctor where f_name like concat('%',:name,'%')", Doctor.class).setParameter("name", name).list();
	}


	public List<Doctor> searchByLName(String name) {
		Session session= this.sessionFactory.getCurrentSession();
		return session.createQuery("from Doctor where l_name like concat('%',:name,'%')", Doctor.class).setParameter("name", name).list();
	}
	public void insert(Doctor doctor) {
		Session session=sessionFactory.getCurrentSession();
		session.save(doctor);
	}


	public Doctor getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Doctor.class, id);
	}
	


	

}
