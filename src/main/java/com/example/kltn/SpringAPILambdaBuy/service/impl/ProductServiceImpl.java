package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.ProductRepository;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> listProduct = productRepository.findAll();
		if(listProduct != null)
			return listProduct;
		return null;
	}

	@Override
	public ProductEntity findById(String id) {
		ProductEntity product = productRepository.findById(id).get();
		if(product != null)
			return product;
		return null;
	}

	@Override
	public void save(ProductEntity product) {
		productRepository.save(product);
	}

	@Override
	public void delete(String id) {
		productRepository.deleteById(id);
	}
}
