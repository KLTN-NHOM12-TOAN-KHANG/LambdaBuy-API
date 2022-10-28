package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;

public interface SupplierService {
	ResponseCommon<?> findAll();
	ResponseCommon<?> findById(String id);
	ResponseCommon<?> findByName(String name);
	ResponseCommon<?> create(CreateSupplierDto supplierDto);
	ResponseCommon<?> update(UpdateSupplierDto updateSupplierDto);
	ResponseCommon<?> deleteById(String id);
}
