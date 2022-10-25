package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cart")
public class CartEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private int itemQuantity;
	
	@Column
	private boolean isEmpty;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	@OneToMany(mappedBy = "cart")
	private Set<OrderDetail> listOrderDetail;

	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEntity(String id, int itemQuantity, boolean isEmpty, CustomerEntity customer,
			Set<OrderDetail> listOrderDetail) {
		super();
		this.id = id;
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.customer = customer;
		this.listOrderDetail = listOrderDetail;
	}

	public CartEntity(int itemQuantity, boolean isEmpty, CustomerEntity customer, Set<OrderDetail> listOrderDetail) {
		super();
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.customer = customer;
		this.listOrderDetail = listOrderDetail;
	}
	
	public CartEntity(int itemQuantity, boolean isEmpty, CustomerEntity customer) {
		super();
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Set<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(Set<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
}
