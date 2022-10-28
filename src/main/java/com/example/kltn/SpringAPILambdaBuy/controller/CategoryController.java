package com.example.kltn.SpringAPILambdaBuy.controller;

import java.net.URI;
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

import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
import com.example.kltn.SpringAPILambdaBuy.service.CategoryService;



@RestController
@RequestMapping("/api/categorys")
public class CategoryController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private CategoryService service;
	
	@GetMapping("/")
	public List<CategoryEntity> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public CategoryEntity findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@PostMapping("/")
	public void create(@RequestBody CategoryEntity cate) {
		service.create(cate);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CategoryEntity cate, @PathVariable("id") String id){
		try {
			CategoryEntity existbrand = service.findById(id);
			cate.setId(id);
			service.create(cate);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
}
