package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class PaymentEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private Date paidDate;
	
	@Column
	private String detail;
	
	@Column
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
//	@OneToOne(mappedBy = "payment")
//	private OrderEntity order;

	public PaymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentEntity(String id, Date paidDate, String detail, double total, UserEntity user) {
		super();
		this.id = id;
		this.paidDate = paidDate;
		this.detail = detail;
		this.total = total;
		this.user = user;
	}

	public PaymentEntity(Date paidDate, String detail, double total, UserEntity user) {
		super();
		this.paidDate = paidDate;
		this.detail = detail;
		this.total = total;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

//	public OrderEntity getOrder() {
//		return order;
//	}
//
//	public void setOrder(OrderEntity order) {
//		this.order = order;
//	}
}
