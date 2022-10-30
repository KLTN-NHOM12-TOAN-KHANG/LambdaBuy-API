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
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;
	
	@OneToMany(mappedBy = "cart")
	private Set<ProductEntity> listProduct;

	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEntity(Set<ProductEntity> listProduct) {
		super();
		this.listProduct = listProduct;
	}

	public CartEntity(int itemQuantity, boolean isEmpty, ProfileEntity profile, Set<ProductEntity> listProduct) {
		super();
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.profile = profile;
		this.listProduct = listProduct;
	}
	
	public CartEntity(int itemQuantity, boolean isEmpty, ProfileEntity profile) {
		super();
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.profile = profile;
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

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}

	public void setListOrderDetail(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}

	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
}
