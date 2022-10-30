package com.example.kltn.SpringAPILambdaBuy.common.request.cart;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.kltn.SpringAPILambdaBuy.entities.CustomerEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class CreateCartDto {
	private int itemQuantity;
	private boolean isEmpty;
	private CustomerEntity customer;
	private Set<ProductEntity> listProduct;
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
	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}
	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
	public CreateCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateCartDto(int itemQuantity, boolean isEmpty, CustomerEntity customer, Set<ProductEntity> listProduct) {
		super();
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.customer = customer;
		this.listProduct = listProduct;
	}
}
