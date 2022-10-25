package com.example.kltn.SpringAPILambdaBuy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<CartEntity, String> {

}
