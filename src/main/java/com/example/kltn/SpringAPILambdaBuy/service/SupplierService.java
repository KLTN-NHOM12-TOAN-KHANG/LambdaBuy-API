package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;

public interface SupplierService {
	ResponseCommon<List<SupplierEntity>> findAll();
	ResponseCommon<SupplierEntity> findById(String id);
	ResponseCommon<SupplierEntity> findByName(String name);
	void save(SupplierEntity supplier);
	ResponseCommon<?> deleteById(String id);
}
