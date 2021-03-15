package com.medical.dao;

import java.util.List;

import com.medical.pojo.PharmacyStock;

public interface IPharmacyStockDAO {
	public void insert(PharmacyStock pharmacyStock);
	public List<PharmacyStock> getAll();
	public PharmacyStock getById(int medicineId);
	public void update(PharmacyStock pharmacy);
	

}
