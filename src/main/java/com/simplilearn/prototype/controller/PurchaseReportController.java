package com.simplilearn.prototype.controller;

import java.util.Date;
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
import com.simplilearn.prototype.model.PurchaseReport;
import com.simplilearn.prototype.service.PurchaseReportService;

@RestController
public class PurchaseReportController {
	
	@Autowired
	PurchaseReportService purchasereposervice;
	
	@GetMapping(value="/purchaseReports")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReports() {
	    List<PurchaseReport> purchasereports = purchasereposervice.getallPurchaseReports();
	    return new ResponseEntity<>(purchasereports, HttpStatus.OK);
	}
	
	@PostMapping("/purchaseReports")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport purchasereport) {
		PurchaseReport purchasereport1=purchasereposervice.createPurchaseReport(purchasereport);
		return new ResponseEntity<>(purchasereport1,HttpStatus.CREATED);
	}
	
	@GetMapping("/purchaseReports/{id}")
	public ResponseEntity<ApiResponse> getPurchaseReportById(@PathVariable("id") int id)
	{
		Optional<PurchaseReport> product=Optional.of(purchasereposervice.getPurchaseReportById(id));
		
		if (Objects.nonNull(product)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Found the product"), HttpStatus.OK);
		}
		else {
		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "product does not exist"), HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping(value="/purchaseReports/DOP/{dop}")
	public ResponseEntity<List<PurchaseReport>> getPurchaseReportByDateOfPurchase(@PathVariable("dop") Date dop) {
		List<PurchaseReport> productList = purchasereposervice.getPurchaseReportByDOP(dop);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@DeleteMapping("/purchaseReports/{id}")
	public ResponseEntity<Void> deletePurchaseReportById(@PathVariable("id") int id){
	   purchasereposervice.deletePurchaseReportById(id);
	   return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/purchaseReports/Category/{category}")  
	public ResponseEntity<List<PurchaseReport>> getPurchaseReportByDescription(@PathVariable("category") String category ) {
		List<PurchaseReport> products = purchasereposervice.getPurchaseReportByCategory(category);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PutMapping("/purchaseReports/{id}")
	public ResponseEntity<ApiResponse> updatePurchaseReport(@PathVariable("id") Integer id, @RequestBody PurchaseReport purchasereport) {
		// Check to see if the product exists.
		if (Objects.nonNull(purchasereposervice.getPurchaseReportById(id))) {
			// If the product exists then update it.
			purchasereposervice.updatePurchaseReport(id, purchasereport);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the purchase report"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<>(new ApiResponse(false, "purchase report does not exist"), HttpStatus.NOT_FOUND);
	}
	
}



