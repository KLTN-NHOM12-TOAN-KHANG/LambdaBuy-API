package com.example.kltn.SpringAPILambdaBuy.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {
	@EmbeddedId
	private OrderDetailKey id;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	
//	@ManyToOne
//	@MapsId("orderId")
//	@JoinColumn(name = "order_id")
//	private OrderEntity order;
	
	@Column
	private double unitPrice;
	
	@Column
	private int quantity;
	
	@Column
	private double discount;
	

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(OrderDetailKey id, ProductEntity product, double unitPrice, int quantity,
			double discount) {
		super();
		this.id = id;
		this.product = product;
//		this.order = order;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}

	public OrderDetail(ProductEntity product, double unitPrice, int quantity, double discount) {
		super();
		this.product = product;
//		this.order = order;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}

	public OrderDetailKey getId() {
		return id;
	}

	public void setId(OrderDetailKey id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
//
//	public OrderEntity getOrder() {
//		return order;
//	}
//
//	public void setOrder(OrderEntity order) {
//		this.order = order;
//	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}	
}
