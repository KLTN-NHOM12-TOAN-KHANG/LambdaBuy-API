package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.CartRepository;
import com.example.kltn.SpringAPILambdaBuy.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public ResponseCommon<?> getAllProductInCart(String cardId) {
		CartEntity card = cartRepository.findById(cardId).get();
		if(card != null) {
			Set<ProductEntity> listProduct = card.getListProduct();
			Set<ProductResponseDto> listProductDto = new HashSet<>();
			for (ProductEntity productEntity : listProduct) {
				ProductResponseDto productDto = new ProductResponseDto(productEntity.getName(), productEntity.getDescription(), productEntity.getUnitPrice(), productEntity.getDiscount(), productEntity.getImage(), productEntity.getStatus(), productEntity.getInStock(), productEntity.getYearOfManufacture(), productEntity.getCountry(), productEntity.isSpecial(), productEntity.getCreatedDate(), productEntity.getCreatedBy(), productEntity.getUpdatedDate(), productEntity.getUpdatedBy(), productEntity.getIsDeleted());
				listProductDto.add(productDto);
			}
			return new ResponseCommon<>(200, true, "GET_PRODUCT_IN_CART_SUCCESS", listProductDto);
		}
		return null;
	}

	@Override
	public void save(CartEntity cart) {
		cartRepository.save(cart);
	}

	@Override
	public ResponseCommon<?> addProductToCart(String productId, int quantity) {
		
		return null;
	}

	@Override
	public ResponseCommon<?> removeProductToCart(String productId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseCommon<?> updateProductToCart(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseCommon<?> checkQuantityInStock(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseCommon<?> caculateTotalMonney(List<ProductEntity> listProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseCommon<?> addDiscount(float discount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
