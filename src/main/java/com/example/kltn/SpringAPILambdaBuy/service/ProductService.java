package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.ProductRepository;

public interface ProductService {
	public List<ProductEntity> findAll();
	public ProductEntity findById(String id);
	public void save(ProductEntity product);
	public void delete(String id);
}
