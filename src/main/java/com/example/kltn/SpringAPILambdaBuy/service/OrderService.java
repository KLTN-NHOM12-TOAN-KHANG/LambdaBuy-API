package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.checkout.CheckoutItemDto;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

public interface OrderService {

	SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto);

	SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto);
//	public List<OrderEntity> findAll();
//	public OrderEntity findById(String id);
//	public void save(OrderEntity orderEntity);
//	public OrderEntity saveOrder(OrderEntity order);
//	public void createOrder(OrderEntity entity);
//	OrderEntity update(String id,String name, String fullname,String address);
//	void delete(String id);
//	public void createOrderDetail(OrderEntity order, List<OrderDetail> details);
//	public OrderEntity getOrderDetail(String orderId);

	Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException;
}
