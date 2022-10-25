package com.example.kltn.SpringAPILambdaBuy.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.CartRepository;
import com.example.kltn.SpringAPILambdaBuy.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public CartEntity save(CartEntity cart) {
		return cartRepository.save(cart);
	}

}
