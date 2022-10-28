package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public interface CartService {
	ResponseCommon<?> getAllProductInCart(String cardId);
	void save(CartEntity cart);
	ResponseCommon<?> addProductToCart(String productId, int quantity);
	ResponseCommon<?> removeProductToCart(String productId, int quantity);
	ResponseCommon<?> updateProductToCart(String productId);
	ResponseCommon<?> checkQuantityInStock(String productId);
	ResponseCommon<?> caculateTotalMonney(List<ProductEntity> listProduct);
	ResponseCommon<?> addDiscount(float discount);
}
