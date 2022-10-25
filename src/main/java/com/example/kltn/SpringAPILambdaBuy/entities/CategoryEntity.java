package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "category")
public class CategoryEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@OneToMany(mappedBy = "category")
	private Set<ProductEntity> listProduct;

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryEntity(String id, String name, Set<ProductEntity> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.listProduct = listProduct;
	}

	public CategoryEntity(String name, Set<ProductEntity> listProduct) {
		super();
		this.name = name;
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

	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
}
