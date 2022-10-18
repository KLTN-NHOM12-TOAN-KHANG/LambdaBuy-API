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
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<ProductEntity> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ProductEntity findById(@PathVariable("id") String id) {
		return productService.findById(id);
	}
	
	@PostMapping("/")
	public void create(@RequestBody ProductEntity product) {
		productService.save(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ProductEntity product, @PathVariable("id") String id){
		try {
			ProductEntity existProduct = productService.findById(id);
			product.setId(id);
			productService.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		productService.delete(id);
	}
	
	
	
	
}
