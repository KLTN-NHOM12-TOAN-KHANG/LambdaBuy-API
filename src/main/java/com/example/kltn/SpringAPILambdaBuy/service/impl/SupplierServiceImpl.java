package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.SupplierRepository;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public ResponseCommon<?> findAll() {
		List<SupplierEntity> suppliers = supplierRepository.findAll();
		List<SupplierResponseDto> listSupplierDto = new ArrayList<>();
		for (SupplierEntity supplierEntity : suppliers) {
			SupplierResponseDto supplierDto = new SupplierResponseDto(supplierEntity.getId(), supplierEntity.getName(), supplierEntity.getAddress(), supplierEntity.getDescription(), supplierEntity.getIsDeleted(), supplierEntity.getCreatedDate(), supplierEntity.getCreatedBy(), supplierEntity.getUpdatedDate(), supplierEntity.getUpdatedBy()); 
			listSupplierDto.add(supplierDto);
		}
		return new ResponseCommon<>(200, true, "SUCCESS", listSupplierDto);
	}

	@Override
	public ResponseCommon<SupplierResponseDto> findById(String id) {
		SupplierEntity supplierEntity = supplierRepository.findById(id).get();
		if(supplierEntity != null) {
			SupplierResponseDto supplierDto = new SupplierResponseDto(supplierEntity.getId(), supplierEntity.getName(), supplierEntity.getAddress(), supplierEntity.getDescription(), supplierEntity.getIsDeleted(), supplierEntity.getCreatedDate(), supplierEntity.getCreatedBy(), supplierEntity.getUpdatedDate(), supplierEntity.getUpdatedBy()); 
			return new ResponseCommon<>(200, true, "FIND_SUPPLIER_SUCCESS", supplierDto);
		}
		return new ResponseCommon<>(500, false, "SERVER_ERROR_INTERNAL");
	}

	@Override
	public ResponseCommon<SupplierResponseDto> findByName(String name) {
		SupplierEntity supplierEntity = supplierRepository.findByName(name);
		if(supplierEntity != null) {
			SupplierResponseDto supplierDto = new SupplierResponseDto(supplierEntity.getId(), supplierEntity.getName(), supplierEntity.getAddress(), supplierEntity.getDescription(), supplierEntity.getIsDeleted(), supplierEntity.getCreatedDate(), supplierEntity.getCreatedBy(), supplierEntity.getUpdatedDate(), supplierEntity.getUpdatedBy()); 
			return new ResponseCommon<>(200, true, "FIND_SUPPLIER_SUCCESS", supplierDto);
		}
		return new ResponseCommon<>(500, false, "SERVER_ERROR_INTERNAL");
	}

	@Override
	public ResponseCommon<?> create(CreateSupplierDto supplierDto) {
		List<SupplierEntity> listSupplier = supplierRepository.findAll();
		for (SupplierEntity supplierEntity : listSupplier) {
			if(supplierEntity.getName().equalsIgnoreCase(supplierDto.getName())) {
				return new ResponseCommon<>(400, false, "SUPPLIER_ALREADY_EXIST");
			}
		}
		SupplierEntity supplier = new SupplierEntity(supplierDto.getName(), supplierDto.getAddress(), supplierDto.getDescription(), new HashSet<>(), false, new Date(), null);
		supplierRepository.save(supplier);
		return new ResponseCommon<>(200, true, "CREATE_SUPPLIER_SUCCESS", supplier);
	}
	
	@Override
	public ResponseCommon<?> update(UpdateSupplierDto updateSupplierDto) {
		SupplierEntity supplier = supplierRepository.findById(updateSupplierDto.getId()).get();
		if(supplier != null) {
			supplier.setName(updateSupplierDto.getName());
			supplier.setAddress(updateSupplierDto.getAddress());
			supplier.setDescription(updateSupplierDto.getDescription());
			supplier.setListProduct(updateSupplierDto.getListProduct());
			supplier.setIsDeleted(updateSupplierDto.isDeleted());
			supplier.setUpdatedDate(new Date());
			SupplierEntity updateSupplier = supplierRepository.save(supplier);
			return new ResponseCommon<>(200, true, "UPDATE_SUPPLIER_SUCCESS", updateSupplier);
		}
		return new ResponseCommon<>(400, false, "SUPPLIER_NOT_FOUND");
	}

	@Override
	public ResponseCommon<?> deleteById(String id) {
		SupplierEntity supplier = supplierRepository.findById(id).get();
		if(supplier == null) {
			return new ResponseCommon<>(400, false, "SUPPLIER_NOT_FOUND");
		}
		supplier.setIsDeleted(true);
		supplierRepository.save(supplier);
		return new ResponseCommon<>(200, true, "DELETE_SUPPLIER_SUCCESS");
	}

}
