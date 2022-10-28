package com.example.kltn.SpringAPILambdaBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
