package com.medical.dao;


import java.util.List;

import com.medical.pojo.Medicine;

public interface IMedicineDAO {
	public void insert(Medicine medicine);
	public List<Medicine> getAll();
	public List<Medicine> getByName(String name);
	public List<Medicine> getByBrand(String brand);
	public Medicine getById(int medicineId);

}
