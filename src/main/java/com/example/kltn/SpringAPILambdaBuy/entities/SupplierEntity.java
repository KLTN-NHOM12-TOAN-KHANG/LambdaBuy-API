package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "supplier_product",
				joinColumns = @JoinColumn(name = "supplier_id"),
				inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Collection<ProductEntity> listProduct = new ArrayList<>();
	
}
