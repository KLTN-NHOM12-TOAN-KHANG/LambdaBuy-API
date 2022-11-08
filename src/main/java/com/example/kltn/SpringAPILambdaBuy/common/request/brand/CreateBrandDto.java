package com.example.kltn.SpringAPILambdaBuy.common.request.brand;

import java.util.Date;

import javax.persistence.Column;

public class CreateBrandDto {
	private String name;
	private String fullName;
	private String address;
	private boolean isDeleted;
	private Date createdDate;
	private String createdBy;
	
	public CreateBrandDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateBrandDto(String name, String fullName, String address, boolean isDeleted, Date createdDate, String createdBy) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
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
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
}
