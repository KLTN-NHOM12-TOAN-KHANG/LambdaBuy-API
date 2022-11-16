package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetail;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public ProductService productService;
	
	@Override
	public List<OrderEntity> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public OrderEntity findById(String id) {
		return orderRepository.findById(id).isPresent()
				? orderRepository.findById(id).get()
				: null;
	}

	@Override
	public void save(OrderEntity orderEntity) {
		// TODO Auto-generated method stub
		orderRepository.save(orderEntity);
	}
	
	@Override
	public void createOrder(OrderEntity entity) {
		// TODO Auto-generated method stub
//		orderRepository.save(entity);
	}

	@Override
	public OrderEntity update(String id, String name, String fullname, String address) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		OrderEntity order = orderRepository.findById(id).get();
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

	
	@Override
	public void createOrderDetail(OrderEntity order, List<OrderDetail> details) {
		// TODO Auto-generated method stub
//		orderRepository.save(entity);
	}

	@Override
	public OrderEntity getOrderDetail(String orderId) {
		return orderRepository.findById(orderId).isPresent()
								? orderRepository.findById(orderId).get()
								: null;
	}

	@Override
	public OrderEntity saveOrder(OrderEntity order) {
		return orderRepository.save(order);
	}
}
