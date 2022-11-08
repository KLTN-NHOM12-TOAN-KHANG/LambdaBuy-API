package com.example.kltn.SpringAPILambdaBuy.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;

@RestController
@RequestMapping("/api")
public class BrandController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/brands")
	public ResponseEntity<ResponseCommon<List<BrandResponseDto>>> findAllBrand(){
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ALL_BRAND_SUCCESS", brandService.findAll()));
	}
	
	@GetMapping("/brand/{id}")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> findById(@PathVariable("id") String id) {
		BrandResponseDto brandDto = brandService.findById(id);
		if(brandDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "BRAND_NOT_FOUND", null));
	}
	
	@PostMapping("/brand/create")
	public ResponseEntity<ResponseCommon<?>> saveBrand(@RequestBody BrandEntity brand) {
		brandService.save(brand);
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SAVE_BRAND_SUCCESS"));
	}
	
	@PostMapping("/brand/create")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> createBrand(@RequestBody CreateBrandDto createBrandDto) {
		BrandResponseDto brandDto = brandService.create(createBrandDto);
		if(brandDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_BRAND_FAIL", null));
	}
	
	@PostMapping("/brand/update")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> updateBrand(@RequestBody UpdateBrandDto updateBrandDto) {
		BrandResponseDto brandDto = brandService.update(updateBrandDto);
		if(brandDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_BRAND_FAIL", null));
	}
	
	@GetMapping("/brand/delete/{id}")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> deleteBrand(@PathVariable String id) {
		return ResponseEntity.ok().body(new ResponseCommon<BrandResponseDto>(200, true, "DELETE_BRAND_SUCCESS", brandService.deleteById(id)));
	}
}
