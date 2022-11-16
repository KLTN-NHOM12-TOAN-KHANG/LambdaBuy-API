package com.example.kltn.SpringAPILambdaBuy.common.request.category;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class UpdateCategoryDto {
	private String id;
	private String name;
	private Set<ProductEntity> listProduct;
	private boolean isDeleted;
	private Date updatedDate;
	private String updatedBy;
	public UpdateCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateCategoryDto(String id, String name, Set<ProductEntity> listProduct, boolean isDeleted, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.listProduct = listProduct;
		this.isDeleted = isDeleted;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
}
