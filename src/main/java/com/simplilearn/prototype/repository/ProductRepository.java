package com.simplilearn.prototype.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.prototype.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	//Product findByProductDescription(String description);
	
}
