package com.simplilearn.prototype.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.prototype.common.ApiResponse;
import com.simplilearn.prototype.model.Product;
import com.simplilearn.prototype.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping(value="/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> body = productService.listProducts();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product product1=productService.createProduct(product);
		return new ResponseEntity<>(product1,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ApiResponse> getProductById(@PathVariable("id") int id)
	{
		Optional<Product> product=Optional.of(productService.findProductById(id));
		
		if (Objects.nonNull(product)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Found the product"), HttpStatus.OK);
		}
		else {
		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "product does not exist"), HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping(value="/products/price/{price}")
	public ResponseEntity<List<Product>> getProductByPrice(@PathVariable("price") int price) {
		List<Product> productList = productService.findProductsByPrice(price);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@GetMapping(value="/products/Descr/{description}")  
	public ResponseEntity<List<Product>> getProductByDescription(@PathVariable("description") String description) {
		List<Product> products = productService.findProductByDesription(description);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		// Check to see if the product exists.
		if (Objects.nonNull(productService.findProductById(id))) {
			// If the product exists then update it.
			productService.updateProduct(id, product);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the product"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<>(new ApiResponse(false, "product does not exist"), HttpStatus.NOT_FOUND);
	}
  
   @DeleteMapping("/products/{id}")
   public ResponseEntity<Void> deleteProductById(@PathVariable("id") int productId){
	   productService.deleteProductById(productId);
	   return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
   }
	
}



