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
import com.simplilearn.prototype.model.User;
import com.simplilearn.prototype.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/users")
	public ResponseEntity<List<User>> getusers() {
	    List<User> users = userService.listUsers();
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1=userService.addUser(user);
		return new ResponseEntity<>(user1,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/search/getUserByUsername/{username}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable("username") String name)
	{
		List<User> users=userService.getUsersByUsername(name);	
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping(value="/users/search/getUserByEmailId/{emailId}")
	public ResponseEntity<List<User>> getUserByEmailId(@PathVariable("emailId") String emailId) {
		List<User> users = userService.getUserByEmailId(emailId);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<ApiResponse> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		// Check to see if the product exists.
		if (Objects.nonNull(userService.getUserById(id))) {
			// If the product exists then update it.
			userService.updateUser(id, user);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the product"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<>(new ApiResponse(false, "product does not exist to update"), HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") int id){
	   userService.deleteUser(id);
	   return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}





