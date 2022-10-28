package com.example.kltn.SpringAPILambdaBuy.common.request.supplier;

import java.util.Date;
import java.util.Set;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class UpdateSupplierDto {
	private String id;
	private String name;
	private String address;
	private String description;
	private Set<ProductEntity> listProduct;
	private boolean isDeleted;
	private Date updatedDate;
	private String updatedBy;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}
	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
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
	public UpdateSupplierDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateSupplierDto(String id, String name, String address, String description, Set<ProductEntity> listProduct,
			boolean isDeleted, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.listProduct = listProduct;
		this.isDeleted = isDeleted;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
}
