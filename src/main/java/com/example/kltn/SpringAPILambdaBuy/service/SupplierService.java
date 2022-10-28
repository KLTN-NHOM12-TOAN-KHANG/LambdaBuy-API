package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

<<<<<<< HEAD
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
=======
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;

public interface SupplierService {
<<<<<<< HEAD
	ResponseCommon<?> findAll();
	ResponseCommon<?> findById(String id);
	ResponseCommon<?> findByName(String name);
	ResponseCommon<?> create(CreateSupplierDto supplierDto);
	ResponseCommon<?> update(UpdateSupplierDto updateSupplierDto);
=======
	ResponseCommon<List<SupplierEntity>> findAll();
	ResponseCommon<SupplierEntity> findById(String id);
	ResponseCommon<SupplierEntity> findByName(String name);
	void save(SupplierEntity supplier);
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
	ResponseCommon<?> deleteById(String id);
}
