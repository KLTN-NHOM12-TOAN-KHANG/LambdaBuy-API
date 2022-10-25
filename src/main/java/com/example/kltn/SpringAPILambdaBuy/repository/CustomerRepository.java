package com.example.kltn.SpringAPILambdaBuy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.CustomerEntity;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}
