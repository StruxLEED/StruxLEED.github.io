package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
