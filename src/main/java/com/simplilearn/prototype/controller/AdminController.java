package com.simplilearn.prototype.controller;

import java.util.List;
import java.util.Objects;

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
import com.simplilearn.prototype.model.Admin;
import com.simplilearn.prototype.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@GetMapping(value="/admins")
	public ResponseEntity<List<Admin>> getAllAdmins() {
	    List<Admin> admins = adminservice.getAllAdmins();
	    return new ResponseEntity<>(admins, HttpStatus.OK);
	}
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> createUser(@RequestBody Admin admin) {
		Admin admin1=adminservice.addAdmin(admin);
		return new ResponseEntity<>(admin1,HttpStatus.CREATED);
	}
	
	@GetMapping("/admins/search/getAdminByUsername/{username}")
	public ResponseEntity<List<Admin>> getAdminByName(@PathVariable("username") String name)
	{
		List<Admin> admins=adminservice.findByUsername(name);
		return new ResponseEntity<>(admins,HttpStatus.OK);
	}	
	
	@GetMapping(value="/admins/search/getUserByEmailId/{emailId}")
	public ResponseEntity<List<Admin>> getAdminByEmailId(@PathVariable("emailId") String emailId) {
		List<Admin> admins = adminservice.getAdminByEmailId(emailId);
		return new ResponseEntity<>(admins, HttpStatus.OK);
	}
	
	@PutMapping("/admins/{id}")
	public ResponseEntity<ApiResponse> updateAdmin(@PathVariable("id") Integer id, @RequestBody Admin admin) {
		// Check to see if the product exists.
		if (Objects.nonNull(adminservice.findAdminById(id))) {
			// If the product exists then update it.
			adminservice.updateAdmin(id, admin);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the Admin"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<>(new ApiResponse(false, "Admin does not exist to update"), HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/admins/{id}")
	public ResponseEntity<Void> deleteAdminById(@PathVariable("id") int id){
	   adminservice.deleteAdmin(id);
	   return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	

}







