package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;

import com.example.kltn.SpringAPILambdaBuy.repository.BrandRepository;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<BrandResponseDto> findAll() {
		List<BrandEntity> list = brandRepository.findAll();
		List<BrandResponseDto> listDto = new ArrayList<>();
		for (BrandEntity brand : list) {
			BrandResponseDto brandDto = new BrandResponseDto(brand.getId(), brand.getName(), brand.getFullName(), brand.getAddress(), brand.getIsDeleted(), brand.getCreatedDate(), brand.getCreatedBy(), brand.getUpdatedDate(), brand.getUpdatedBy());
			listDto.add(brandDto);
		}
		return listDto;
	}

	@Override
	public BrandResponseDto findById(String id) {
		BrandEntity brand = brandRepository.findById(id).isPresent() 
							? brandRepository.findById(id).get()
							: null;
		if(brand != null) {
			BrandResponseDto brandDto = new BrandResponseDto(brand.getId(), brand.getName(), brand.getFullName(), brand.getAddress(), brand.getIsDeleted(), brand.getCreatedDate(), brand.getCreatedBy(), brand.getUpdatedDate(), brand.getUpdatedBy());
			return brandDto;
		}
		return null;
	}
	
	@Override
	public void save(BrandEntity brand) {
		brandRepository.save(brand);
	}

	@Override
	public BrandResponseDto create(CreateBrandDto createBrandDto) {
		BrandEntity brand = new BrandEntity(createBrandDto.getName(), createBrandDto.getFullName(), createBrandDto.getAddress(), new HashSet<>(), false, new Date(), "admin", null, null);
		BrandEntity createBrand = brandRepository.save(brand);
		if(createBrand != null) {
			BrandResponseDto brandDto = new BrandResponseDto(createBrand.getId(), createBrand.getName(), createBrand.getFullName(), createBrand.getAddress(), createBrand.getIsDeleted(), createBrand.getCreatedDate(), createBrand.getCreatedBy(), createBrand.getUpdatedDate(), createBrand.getUpdatedBy());
			return brandDto;
		}
		return null;
	}

	@Override
	public BrandResponseDto update(UpdateBrandDto updateBrandDto) {
		BrandEntity brand = brandRepository.findById(updateBrandDto.getId()).isPresent()
								? brandRepository.findById(updateBrandDto.getId()).get()
								: null;
		if(brand != null) {
			brand.setName(updateBrandDto.getName());
			brand.setFullName(updateBrandDto.getFullName());
			brand.setAddress(updateBrandDto.getAddress());
			brand.setListProduct(updateBrandDto.getListProduct());
			brand.setUpdatedDate(new Date());
			BrandEntity updateBrand = brandRepository.save(brand);
			BrandResponseDto brandDto = new BrandResponseDto(updateBrand.getId(), updateBrand.getName(), updateBrand.getFullName(), updateBrand.getAddress(), updateBrand.getIsDeleted(), updateBrand.getCreatedDate(), updateBrand.getCreatedBy(), updateBrand.getUpdatedDate(), updateBrand.getUpdatedBy());
			return brandDto;
		}
		return null;
	}

	@Override
	public BrandResponseDto deleteById(String id) {
		BrandEntity brand = brandRepository.findById(id).isPresent()
				? brandRepository.findById(id).get()
				: null;
		if(brand != null) {
			brand.setIsDeleted(true);
			BrandEntity deleteBrand = brandRepository.save(brand);
			BrandResponseDto brandDto = new BrandResponseDto(deleteBrand.getId(), deleteBrand.getName(), deleteBrand.getFullName(), deleteBrand.getAddress(), deleteBrand.getIsDeleted(), deleteBrand.getCreatedDate(), deleteBrand.getCreatedBy(), deleteBrand.getUpdatedDate(), deleteBrand.getUpdatedBy());
			return brandDto;
		}
		return null;
	}

}
