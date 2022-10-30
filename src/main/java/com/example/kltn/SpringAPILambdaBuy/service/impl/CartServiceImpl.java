package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.cart.CreateCartDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.CartRepository;
import com.example.kltn.SpringAPILambdaBuy.service.CartService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductService productService;

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
	public ResponseCommon<?> addProductToCart(String cartId, String productId) {
		CartEntity cart = cartRepository.findById(cartId).get();
		Set<ProductEntity> listProduct = cart.getListProduct();
		
		ProductEntity product = productService.findById(productId);
		listProduct.add(product);
		cart.setListProduct(listProduct);
		cartRepository.save(cart);
		
		product.setIsEnabled(false);
		productService.save(product);
		
		return new ResponseCommon<>(200, true, "ADD_PRODUCT_TO_CART_SUCCESS");
	}

	@Override
	public ResponseCommon<?> removeProductToCart(String cartId, String productId) {
		CartEntity cart = cartRepository.findById(cartId).get();
		Set<ProductEntity> listProduct = cart.getListProduct();
		
		ProductEntity product = productService.findById(productId);
		listProduct.remove(product);
		
		cart.setListProduct(listProduct);
		cartRepository.save(cart);
		
		product.setIsEnabled(true);
		productService.save(product);
		return new ResponseCommon<>(200, true, "REMOVE_PRODUCT_TO_CART_SUCCESS");
	}
	
	@Override
	public ResponseCommon<?> addQuantityInCart(String cartId, String productId, int quantity) {
		ProductEntity product = productService.findById(productId);
		if(quantity >= product.getInStock()) {
			return new ResponseCommon<>(400, false, "GREATE_THAN_STOCK");
		}
		return new ResponseCommon<>(200, true, "SUCCESS");
	}

	@Override
	public ResponseCommon<?> subQuantityInCart(String cartId, String productId, int quantity) {
		ProductEntity product = productService.findById(productId);
		if(quantity <= 1) {
			removeProductToCart(cartId, productId);
		}
		return new ResponseCommon<>(200, true, "SUCCESS");
	}
}
