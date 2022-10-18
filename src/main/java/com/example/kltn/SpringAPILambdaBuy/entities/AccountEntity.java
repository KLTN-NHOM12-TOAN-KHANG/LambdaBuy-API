package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "account")
public class AccountEntity {
	@Id
	@PrimaryKeyJoinColumn
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private UserStatus status;
	
	@Column
	private boolean isDeleted;
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@Column
	@CreatedBy
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column String updatedBy;
}
