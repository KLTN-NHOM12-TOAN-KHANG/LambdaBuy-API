package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;

import com.example.kltn.SpringAPILambdaBuy.repository.BrandRepository;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
	@Autowired
	BrandRepository repository;
	@Override
	public List<BrandEntity> findAll() {
		List<BrandEntity> list = repository.findAll();
		if(list != null)
			return list;
		return null;
	}

	@Override
	public BrandEntity findById(String id) {
		BrandEntity brand = repository.findById(id).get();
		if(brand != null)
			return brand;
		return null;
	}

	@Override
	public void create(BrandEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public BrandEntity update(String id,String name, String fullname,String address) {
		// TODO Auto-generated method stub
		BrandEntity brand = repository.findById(id).get();
		brand.setId(id);
		brand.setName(name);
		brand.setFullName(fullname);
		brand.setAddress(address);
		repository.save(brand);
		return brand;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
