package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column
	private Date shippedDate;
	
	@Column
	private String shippedAddress;
	
	@Column
	private String status;
	
	@Column
	private double total;
	
	@Column
	private String description;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private PaymentEntity payment;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdminEntity admin;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	
	@OneToMany(mappedBy = "order")
	Set<OrderDetail> listOrderDetail;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(String id, Date shippedDate, String shippedAddress, String status, double total,
			String description, PaymentEntity payment, AdminEntity admin, Set<OrderDetail> listOrderDetail) {
		super();
		this.id = id;
		this.shippedDate = shippedDate;
		this.shippedAddress = shippedAddress;
		this.status = status;
		this.total = total;
		this.description = description;
		this.payment = payment;
		this.admin = admin;
		this.listOrderDetail = listOrderDetail;
	}

	public OrderEntity(Date shippedDate, String shippedAddress, String status, double total, String description,
			PaymentEntity payment, AdminEntity admin, Set<OrderDetail> listOrderDetail) {
		super();
		this.shippedDate = shippedDate;
		this.shippedAddress = shippedAddress;
		this.status = status;
		this.total = total;
		this.description = description;
		this.payment = payment;
		this.admin = admin;
		this.listOrderDetail = listOrderDetail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getShippedAddress() {
		return shippedAddress;
	}

	public void setShippedAddress(String shippedAddress) {
		this.shippedAddress = shippedAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentEntity getPayment() {
		return payment;
	}

	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public Set<OrderDetail> getOrderDetails() {
		return listOrderDetail;
	}

	public void setOrderDetails(Set<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
}
