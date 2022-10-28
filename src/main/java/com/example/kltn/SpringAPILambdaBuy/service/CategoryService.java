package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;

public interface CategoryService {
	public List<CategoryEntity> findAll();
	
	public CategoryEntity findById(String id);
	public void create(CategoryEntity entity);
	
	CategoryEntity update(String id,String name, String fullname,String address);
	
	void delete(String id);
}
