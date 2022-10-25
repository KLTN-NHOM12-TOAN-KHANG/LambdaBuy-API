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
@Table(name = "admin")
public class AdminEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	@OneToOne
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserEntity user;
	
	@OneToMany(mappedBy = "admin")
	private Set<OrderEntity> listOrder;
	
	@OneToMany(mappedBy = "admin")
	private Set<ProductEntity> listProduct;

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEntity(String id, String firstName, String lastName, UserEntity user, Set<OrderEntity> listOrder,
			Set<ProductEntity> listProduct) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.listOrder = listOrder;
		this.listProduct = listProduct;
	}

	public AdminEntity(String firstName, String lastName, UserEntity user, Set<OrderEntity> listOrder,
			Set<ProductEntity> listProduct) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.listOrder = listOrder;
		this.listProduct = listProduct;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Set<OrderEntity> getListOrder() {
		return listOrder;
	}

	public void setListOrder(Set<OrderEntity> listOrder) {
		this.listOrder = listOrder;
	}

	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
}
