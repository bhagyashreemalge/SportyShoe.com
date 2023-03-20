package com.simplilearn.prototype.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.prototype.model.User;
import com.simplilearn.prototype.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	
	public List<User> listUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User getUserById(int id)
	{
		return userRepository.findById(id).get();
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	
	public List<User> getUsersByUsername(String username){
		return ((Collection<User>) userRepository.findAll()).stream().filter(i->i.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
	}


	public List<User> getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return ((Collection<User>) userRepository.findAll()).stream().filter(i->i.getEmailId().equalsIgnoreCase(emailId)).collect(Collectors.toList());
	}

	
	public User getUserByContactNo(String contactNo) {
		// TODO Auto-generated method stub
		return userRepository.getUserByContactNo(contactNo);
	}

	public void updateUser(int id, User user) {
			User newUser = userRepository.findById(id).get();
			newUser.setUsername(user.getUsername());
			newUser.setEmailId(user.getEmailId());
			newUser.setPassword(user.getPassword());
			newUser.setContactNo(user.getContactNo());
			userRepository.save(newUser);			
	}


	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);	
	}
	
	

	
}
