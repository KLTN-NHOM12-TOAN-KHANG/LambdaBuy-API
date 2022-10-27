package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.SupplierRepository;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public ResponseCommon<List<SupplierEntity>> findAll() {
		List<SupplierEntity> suppliers = supplierRepository.findAll();
		List<SupplierEntity> listSupplier = new ArrayList<>();
		for (SupplierEntity supplierEntity : suppliers) {
			if(supplierEntity.getIsDeleted() == false) {
				listSupplier.add(supplierEntity);
			}
		}
		return new ResponseCommon<>(200, true, "SUCCESS", suppliers);
	}

	@Override
	public ResponseCommon<SupplierEntity> findById(String id) {
		SupplierEntity supplier = supplierRepository.findById(id).get();
		if(supplier != null) {
			return new ResponseCommon<>(200, true, "SUCCESS", supplier);
		}
		return new ResponseCommon<>(500, false, "SERVER_ERROR_INTERNAL");
	}

	@Override
	public ResponseCommon<SupplierEntity> findByName(String name) {
		SupplierEntity supplier = supplierRepository.findByName(name);
		if(supplier != null) {
			return new ResponseCommon<>(200, true, "SUCCESS", supplier);
		}
		return new ResponseCommon<>(500, false, "SERVER_ERROR_INTERNAL");
	}

	@Override
	public void save(SupplierEntity supplier) {
		supplierRepository.save(supplier);
	}

	@Override
	public ResponseCommon<?> deleteById(String id) {
		SupplierEntity supplier = findById(id).data;
		if(supplier == null) {
			return new ResponseCommon<>(400, false, "SUPPLIER_NOT_FOUND");
		}
		supplier.setIsDeleted(true);
		save(supplier);
		return new ResponseCommon<>(200, true, "DELETE_SUCCESS");
	}

}
