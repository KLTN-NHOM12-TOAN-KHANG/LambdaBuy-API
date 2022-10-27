package com.example.kltn.SpringAPILambdaBuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/suppliers/")
	public ResponseCommon<List<SupplierEntity>> findAllSupplier() {
		return supplierService.findAll();
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseCommon<SupplierEntity> findById(@PathVariable("id") String id){
		return supplierService.findById(id);
	}
	
}
