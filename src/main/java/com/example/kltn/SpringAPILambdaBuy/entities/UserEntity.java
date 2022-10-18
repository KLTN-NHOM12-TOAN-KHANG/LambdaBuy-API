package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String address;
	
	@Column
	private String avatar;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountEntity account;
	
}
