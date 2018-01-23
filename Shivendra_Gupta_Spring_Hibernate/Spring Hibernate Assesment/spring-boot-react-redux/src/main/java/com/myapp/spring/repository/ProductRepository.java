package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	List<Product> findAll();
	Product findOne(int id);
	Product findByName(String name);
}
