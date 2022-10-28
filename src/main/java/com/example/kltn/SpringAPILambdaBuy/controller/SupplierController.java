package com.example.kltn.SpringAPILambdaBuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
=======
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
<<<<<<< HEAD
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
=======
	@GetMapping("/suppliers/")
	public ResponseCommon<List<SupplierEntity>> findAllSupplier() {
		return supplierService.findAll();
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseCommon<SupplierEntity> findById(@PathVariable("id") String id){
		return supplierService.findById(id);
	}
	
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
}
