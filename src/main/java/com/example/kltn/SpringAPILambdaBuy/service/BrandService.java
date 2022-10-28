package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;

public interface BrandService {
	public List<BrandEntity> findAll();
	
	public BrandEntity findById(String id);
	public void create(BrandEntity entity);
	
	BrandEntity update(String id,String name, String fullname,String address);
	
	void delete(String id);
}
