package com.example.kltn.SpringAPILambdaBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(supplierService.findAll());
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		return ResponseEntity.ok().body(supplierService.findById(id));
	}
	
	@GetMapping("/supplier/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable("name") String name){
		return ResponseEntity.ok().body(supplierService.findByName(name));
	}
	
	@PostMapping("/supplier")
	public ResponseEntity<?> createSupplier(@RequestBody CreateSupplierDto supplierDto) {
		return ResponseEntity.ok().body(supplierService.create(supplierDto));
	}
	
	@PutMapping("/supplier")
	public ResponseEntity<?> updateSupplier(@RequestBody UpdateSupplierDto updateSupplier) {
		return ResponseEntity.ok().body(supplierService.update(updateSupplier));
	}
	
	@DeleteMapping("/supplier/{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(supplierService.deleteById(id));
	}
}
