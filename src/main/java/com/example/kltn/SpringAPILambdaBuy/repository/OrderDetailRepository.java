package com.example.kltn.SpringAPILambdaBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
