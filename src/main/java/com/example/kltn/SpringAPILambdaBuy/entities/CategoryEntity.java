package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity()
@Table(name = "category")
public class CategoryEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> listProduct;
}
