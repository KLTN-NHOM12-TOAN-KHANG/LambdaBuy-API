package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity()
@Table(name = "brand")
public class BrandEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column()
	private String address;
	
//	@OneToMany(mappedBy = "brand")
//	private List<ProductEntity> listProduct;
}
