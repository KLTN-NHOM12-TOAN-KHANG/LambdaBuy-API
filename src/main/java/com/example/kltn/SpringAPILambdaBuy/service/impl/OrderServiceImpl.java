package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.checkout.CheckoutItemDto;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetail;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public ProductService productService;
	
	@Value("${webURL}")
	private String webURL;
	
	@Value("${STRIPE_SECRET_KEY}")
	private String apiKey;
	
	@Override
	public SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
		return SessionCreateParams.LineItem.PriceData.builder()
					.setCurrency("usd")
					.setUnitAmount(((long) checkoutItemDto.getPrice()) * 100)
					.setProductData(
							SessionCreateParams.LineItem.PriceData.ProductData.builder()
								.setName(checkoutItemDto.getProductName())
								.build())
					.build();
	}
	
	@Override
	public SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto) {
	    return SessionCreateParams.LineItem.builder()
	            .setPriceData(createPriceData(checkoutItemDto))
	            .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
	            .build();
	}
	
	@Override
	public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {

	    String successURL = webURL + "payment/success";
	    String failedURL = webURL + "payment/failed";

	    Stripe.apiKey = apiKey;

	    List<SessionCreateParams.LineItem> sessionItemsList = new ArrayList<SessionCreateParams.LineItem>();
	    for (CheckoutItemDto checkoutItemDto : checkoutItemDtoList) {
	        sessionItemsList.add(createSessionLineItem(checkoutItemDto));
	    }

	    SessionCreateParams params = SessionCreateParams.builder()
	            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	            .setMode(SessionCreateParams.Mode.PAYMENT)
	            .setCancelUrl(failedURL)
	            .addAllLineItem(sessionItemsList)
	            .setSuccessUrl(successURL)
	            .build();
	    return Session.create(params);
	}
//	@Override
//	public List<OrderEntity> findAll() {
//		return orderRepository.findAll();
//	}
//
//	@Override
//	public OrderEntity findById(String id) {
//		return orderRepository.findById(id).isPresent()
//				? orderRepository.findById(id).get()
//				: null;
//	}
//
//	@Override
//	public void save(OrderEntity orderEntity) {
//		// TODO Auto-generated method stub
//		orderRepository.save(orderEntity);
//	}
//	
//	@Override
//	public void createOrder(OrderEntity entity) {
//		// TODO Auto-generated method stub
////		orderRepository.save(entity);
//	}
//
//	@Override
//	public OrderEntity update(String id, String name, String fullname, String address) {
//		// TODO Auto-generated method stub
//			// TODO Auto-generated method stub
//		OrderEntity order = orderRepository.findById(id).get();
//		/*
//		order.setId(id);
//		order.setName(name);
//		order.setFullName(fullname);
//		order.setAddress(address);
//		repository.save(order);
//		*/
//		return order;
//	}
//
//	@Override
//	public void delete(String id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	@Override
//	public void createOrderDetail(OrderEntity order, List<OrderDetail> details) {
//		// TODO Auto-generated method stub
////		orderRepository.save(entity);
//	}
//
//	@Override
//	public OrderEntity getOrderDetail(String orderId) {
//		return orderRepository.findById(orderId).isPresent()
//								? orderRepository.findById(orderId).get()
//								: null;
//	}
//
//	@Override
//	public OrderEntity saveOrder(OrderEntity order) {
//		return orderRepository.save(order);
//	}
}
