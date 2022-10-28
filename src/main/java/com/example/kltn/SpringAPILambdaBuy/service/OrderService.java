package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;

public interface OrderService {
	public List<OrderEntity> findAll();
	
	public OrderEntity findById(String id);
	public void create(OrderEntity entity);
	
	OrderEntity update(String id,String name, String fullname,String address);
	
	void delete(String id);
}
