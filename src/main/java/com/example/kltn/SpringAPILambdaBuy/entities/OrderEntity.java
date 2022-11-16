package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
//	@Column
//	private Date shippedDate;
//	
//	@Column
//	private String shippedAddress;
//	
//	@Column
//	private double total;
	
	@Column
	private String description;
	
//	@OneToOne
//	@JoinColumn(name = "payment_id")
//	private PaymentEntity payment;
	/*
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdminEntity admin;
	*/
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;
	
//	@OneToMany(mappedBy = "order")
//	Set<OrderDetail> listOrderDetail;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public OrderEntity(String description, UserEntity user) {
		super();
		this.description = description;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Date getShippedDate() {
//		return shippedDate;
//	}
//
//	public void setShippedDate(Date shippedDate) {
//		this.shippedDate = shippedDate;
//	}
//
//	public String getShippedAddress() {
//		return shippedAddress;
//	}
//
//	public void setShippedAddress(String shippedAddress) {
//		this.shippedAddress = shippedAddress;
//	}
//
//	public double getTotal() {
//		return total;
//	}
//
//	public void setTotal(double total) {
//		this.total = total;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public PaymentEntity getPayment() {
//		return payment;
//	}
//
//	public void setPayment(PaymentEntity payment) {
//		this.payment = payment;
//	}
//	
//	public Set<OrderDetail> getOrderDetails() {
//		return listOrderDetail;
//	}
//
//	public void setOrderDetails(Set<OrderDetail> listOrderDetail) {
//		this.listOrderDetail = listOrderDetail;
//	}
	

//	public Set<OrderDetail> getListOrderDetail() {
//		return listOrderDetail;
//	}
//
//	public void setListOrderDetail(Set<OrderDetail> listOrderDetail) {
//		this.listOrderDetail = listOrderDetail;
//	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
