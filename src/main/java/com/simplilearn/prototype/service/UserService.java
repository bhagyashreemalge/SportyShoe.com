package com.simplilearn.prototype.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.simplilearn.prototype.model.User;

@Service
public interface UserService {
	
	List<User> listUsers();
	User getUserById(int id);
	User addUser(User user);
	List<User> getUsersByUsername(String username);
	List<User> getUserByEmailId(String emailId);
	User getUserByContactNo(String contactNo);
	void updateUser(int id,User user);
	void deleteUser(int id);	
	
}
