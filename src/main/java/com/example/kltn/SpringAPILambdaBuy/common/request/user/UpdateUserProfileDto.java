package com.example.kltn.SpringAPILambdaBuy.common.request.user;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.entities.PaymentEntity;

public class UpdateUserProfileDto {
	private String id;
	private String username;
	private String email;
	private String password;
	private boolean locked;
	private boolean enabled;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private UpdateProfileDto profile;
	private Set<PaymentEntity> listPayment;
	
	public UpdateUserProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateUserProfileDto(String id, String username, String email, String password, boolean locked, boolean enabled, Date createdDate, String createdBy, Date updatedDate,
			String updatedBy, UpdateProfileDto profile, List<PaymentEntity> listPayment) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.locked = locked;
		this.enabled = enabled;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.profile = profile;
		this.listPayment = this.listPayment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIsLocked() {
		return locked;
	}
	public void setIsLocked(boolean locked) {
		this.locked = locked;
	}
	public boolean getIsEnabled() {
		return enabled;
	}
	public void setIsEnabled(boolean enabled) {
		this.enabled = enabled;
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
	public UpdateProfileDto getProfile() {
		return profile;
	}
	public void setProfile(UpdateProfileDto profile) {
		this.profile = profile;
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
	public Set<PaymentEntity> getListPayment() {
		return listPayment;
	}
	public void setListPayment(Set<PaymentEntity> listPayment) {
		this.listPayment = listPayment;
	}
}
