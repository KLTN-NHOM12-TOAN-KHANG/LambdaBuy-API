package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String phoneNumber;
	
	@Column
	private String address;
	
	@Column
	private String avatar;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne(mappedBy = "customer")
	private CartEntity cart;

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(String id, String phoneNumber, String address, String avatar, String firstName,
			String lastName, UserEntity user, CartEntity cart) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.cart = cart;
	}

	public CustomerEntity(String phoneNumber, String address, String avatar, String firstName, String lastName,
			UserEntity user, CartEntity cart) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.cart = cart;
	}
	

	public CustomerEntity(String firstName, String lastName, UserEntity user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
}
