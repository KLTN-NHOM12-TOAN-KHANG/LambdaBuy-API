package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetail;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderDetailRepository;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderDetailService;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;

public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	public OrderDetailRepository repository;
	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		List<OrderDetail> list = repository.findAll();
		if(list != null)
			return list;
		return null;
	}

	@Override
	public OrderDetail findById(String id) {
		// TODO Auto-generated method stub
		OrderDetail order = repository.findById(id).get();
		if(order != null)
			return order;
		return null;
	}

	@Override
	public void create(OrderDetail entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public OrderDetail update(String id,String orderId, String productId,double unitPrice,int quantity,float discount) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		OrderDetail od = repository.findById(id).get();
		/*
		order.setId(id);
		order.setName(name);
		order.setFullName(fullname);
		order.setAddress(address);
		repository.save(order);
		*/
		return od;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
