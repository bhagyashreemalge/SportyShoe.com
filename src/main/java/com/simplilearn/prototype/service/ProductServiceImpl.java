package com.simplilearn.prototype.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.prototype.model.Product;
import com.simplilearn.prototype.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productrepository;
	
	@Transactional
	public List<Product> listProducts() {
		return (List<Product>) productrepository.findAll();
	}

	public Product createProduct(Product product) {
		return productrepository.save(product);
	}

	public Product findProductById(Integer id) {
		return productrepository.findById(id).get();
	}

	/*public Product findProductByName(String name) {
		return productrepository.findByProductName(name);
	}*/

	public void updateProduct(Integer productID, Product product) {
		Product newProduct = productrepository.findById(productID).get();
		newProduct.setCategory(product.getCategory());
		newProduct.setDescription(product.getDescription());
		newProduct.setImgurl(product.getImgurl());
		productrepository.save(newProduct);
	}

	public void deleteProductById(Integer id)
	{
		productrepository.deleteById(id);
	}

	public List<Product> findProductsByPrice(Integer price)
	{
		List<Product> productList = new ArrayList<Product>();
		productList = ((Collection<Product>) productrepository.findAll()).stream().filter(i -> i.getPrice() <= price).collect(Collectors.toList());
		return productList;
	}

	@Override
	public List<Product> findProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		productList = ((Collection<Product>) productrepository.findAll()).stream().filter(i -> i.getDescription().equalsIgnoreCase(name)).collect(Collectors.toList());
		return productList;
	}

	@Override
	public List<Product> findProductByDesription(String description) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		productList = ((Collection<Product>) productrepository.findAll()).stream().filter(i -> i.getDescription().equalsIgnoreCase(description)).collect(Collectors.toList());
		return productList;
	}

}









