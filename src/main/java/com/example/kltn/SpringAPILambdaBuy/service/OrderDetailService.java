package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetail;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;


public interface OrderDetailService {
	public List<OrderDetail> findAll();
	public OrderDetail findById(String id);
	public void save(OrderDetail orderDetail);
	public void create(OrderDetail entity);
	OrderDetail update(String id,String orderId, String productId,double unitPrice,int quantity,float discount);
	void delete(String id);
	List<OrderDetail> findByOrder(OrderEntity order);
}
