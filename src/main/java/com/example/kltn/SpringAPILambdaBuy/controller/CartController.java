package com.example.kltn.SpringAPILambdaBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/products/{id}")
	public ResponseEntity<?> getProductsInCart(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(cartService.getAllProductInCart(id));
	}
}
