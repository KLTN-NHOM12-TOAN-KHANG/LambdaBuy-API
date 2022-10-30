package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.cart.CreateCartDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public interface CartService {
	ResponseCommon<?> getAllProductInCart(String cardId);
	void save(CartEntity cart);
	ResponseCommon<?> addProductToCart(String cartId, String productId);
	ResponseCommon<?> removeProductToCart(String cartId, String productId);
	ResponseCommon<?> addQuantityInCart(String cartId, String productId, int quantity);
	ResponseCommon<?> subQuantityInCart(String cartId, String productId, int quantity);
}
