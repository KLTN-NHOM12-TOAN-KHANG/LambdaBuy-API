package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "profile")
public class ProfileEntity {
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
	
	@Column
	private Date createdDate;
	
	@Column
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne(mappedBy = "profile")
	private CartEntity cart;
	
	@OneToMany(mappedBy = "profile")
	private Set<OrderEntity> listOrder;

	public ProfileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfileEntity(String id, String phoneNumber, String address, String avatar, String firstName,
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

	public ProfileEntity(String phoneNumber, String address, String avatar, String firstName, String lastName,
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
	

	public ProfileEntity(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public ProfileEntity(String id, String phoneNumber, String address, String avatar, String firstName,
			String lastName, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Set<OrderEntity> getListOrder() {
		return listOrder;
	}

	public void setListOrder(Set<OrderEntity> listOrder) {
		this.listOrder = listOrder;
	}
}
