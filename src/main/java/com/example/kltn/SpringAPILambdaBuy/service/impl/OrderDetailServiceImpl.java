package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetail;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderDetailRepository;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderDetailService;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;

public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	public OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDetail> findAll() {
		return orderDetailRepository.findAll();

	}

	@Override
	public OrderDetail findById(String id) {
		return orderDetailRepository.findById(id).isPresent()
					? orderDetailRepository.findById(id).get()
					: null;
		
	}
	
	@Override
	public void save(OrderDetail entity) {
		// TODO Auto-generated method stub
		orderDetailRepository.save(entity);
	}

	@Override
	public void create(OrderDetail entity) {
		// TODO Auto-generated method stub
//		orderDetailRepository.save(entity);
	}

	@Override
	public OrderDetail update(String id,String orderId, String productId,double unitPrice,int quantity,float discount) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		OrderDetail od = orderDetailRepository.findById(id).get();
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

	@Override
	public List<OrderDetail> findByOrder(OrderEntity order) {
		String sql = "FROM orderdetail d WHERE d.order_id=:oid";
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<OrderDetail> query = session.createQuery(sql,OrderDetail.class);
		query.setParameter("oid", order.getId());
		List<OrderDetail> list = query.getResultList();
		return list;
	}

}
