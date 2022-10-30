package com.example.kltn.SpringAPILambdaBuy.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.CustomerRepository;
import com.example.kltn.SpringAPILambdaBuy.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ProfileEntity save(ProfileEntity customer) {
		return customerRepository.save(customer);
	}

}
