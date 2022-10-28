package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;

public interface SupplierService {
	ResponseCommon<?> findAll();
	ResponseCommon<?> findById(String id);
	ResponseCommon<?> findByName(String name);
	ResponseCommon<?> create(CreateSupplierDto createSupplierDto);
	ResponseCommon<?> update(UpdateSupplierDto updateSupplierDto);
	ResponseCommon<?> deleteById(String id);
}
