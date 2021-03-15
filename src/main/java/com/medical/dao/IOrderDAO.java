package com.medical.dao;

import java.util.List;

import com.medical.pojo.Order;

public interface IOrderDAO {
	public List<Order> getAll();
	public List<Order> getAllPending();
	public Order getById(int id);
	public void updateStatus(Order order);
	public void insert(Order order);
}
