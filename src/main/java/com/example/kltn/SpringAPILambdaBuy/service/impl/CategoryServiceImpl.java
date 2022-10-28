package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.BrandRepository;
import com.example.kltn.SpringAPILambdaBuy.repository.CategoryRepository;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
import com.example.kltn.SpringAPILambdaBuy.service.CategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository repository;
	@Override
	public List<CategoryEntity> findAll() {
		List<CategoryEntity> list = repository.findAll();
		if(list != null)
			return list;
		return null;
	}

	@Override
	public CategoryEntity findById(String id) {
		CategoryEntity cate = repository.findById(id).get();
		if(cate != null)
			return cate;
		return null;
	}

	@Override
	public void create(CategoryEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public CategoryEntity update(String id,String name, String fullname,String address) {
		// TODO Auto-generated method stub
		CategoryEntity cate = repository.findById(id).get();
		cate.setId(id);
		cate.setName(name);
		repository.save(cate);
		return cate;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
