package com.example.kltn.SpringAPILambdaBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
