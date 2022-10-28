package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Date;
import java.util.HashSet;
=======
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
=======
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.SupplierRepository;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
<<<<<<< HEAD
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
=======
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
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
	}

	@Override
	public ResponseCommon<?> deleteById(String id) {
<<<<<<< HEAD
		SupplierEntity supplier = supplierRepository.findById(id).get();
=======
		SupplierEntity supplier = findById(id).data;
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
		if(supplier == null) {
			return new ResponseCommon<>(400, false, "SUPPLIER_NOT_FOUND");
		}
		supplier.setIsDeleted(true);
<<<<<<< HEAD
		supplierRepository.save(supplier);
		return new ResponseCommon<>(200, true, "DELETE_SUPPLIER_SUCCESS");
=======
		save(supplier);
		return new ResponseCommon<>(200, true, "DELETE_SUCCESS");
>>>>>>> 50fa5fcd6df2a340efd11e51abfb3b24bfe0ad79
	}

}
