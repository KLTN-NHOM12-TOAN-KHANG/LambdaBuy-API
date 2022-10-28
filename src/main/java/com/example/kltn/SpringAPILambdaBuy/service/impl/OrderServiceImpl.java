package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;

public class OrderServiceImpl implements OrderService {
	@Autowired
	public OrderRepository repository;
	@Override
	public List<OrderEntity> findAll() {
		// TODO Auto-generated method stub
		List<OrderEntity> list = repository.findAll();
		if(list != null)
			return list;
		return null;
	}

	@Override
	public OrderEntity findById(String id) {
		// TODO Auto-generated method stub
		OrderEntity order = repository.findById(id).get();
		if(order != null)
			return order;
		return null;
	}

	@Override
	public void create(OrderEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public OrderEntity update(String id, String name, String fullname, String address) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		OrderEntity order = repository.findById(id).get();
		/*
		order.setId(id);
		order.setName(name);
		order.setFullName(fullname);
		order.setAddress(address);
		repository.save(order);
		*/
		return order;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
