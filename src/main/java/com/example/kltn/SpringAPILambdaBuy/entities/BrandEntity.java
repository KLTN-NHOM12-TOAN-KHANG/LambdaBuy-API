package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "brand")
public class BrandEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@Column
	private String fullName;
	
	@Column()
	private String address;
	
	@OneToMany(mappedBy = "brand")
	private Set<ProductEntity> listProduct;

	public BrandEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandEntity(String id, String name, String fullName, String address, Set<ProductEntity> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.listProduct = listProduct;
	}

	public BrandEntity(String name, String fullName, String address, Set<ProductEntity> listProduct) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.listProduct = listProduct;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
}
