package com.simplilearn.prototype.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.simplilearn.prototype.model.Product;

@Service
public interface ProductService {
	
	List<Product> listProducts();
	Product createProduct(Product product);
	Product findProductById(Integer id);
	List<Product> findProductByName(String name);
	void updateProduct(Integer productID, Product product);
	void deleteProductById(Integer id);
	List<Product> findProductsByPrice(Integer price);
	List<Product> findProductByDesription(String description);
	

}
