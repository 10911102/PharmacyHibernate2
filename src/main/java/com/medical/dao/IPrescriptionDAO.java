package com.medical.dao;

import java.util.List;

import com.medical.pojo.Prescription;

public interface IPrescriptionDAO {
	public void insert(Prescription prescription);
	public List<Prescription> getAll();
	public Prescription getById(int medicineId);
	public void update(Prescription prescription);
	

}
