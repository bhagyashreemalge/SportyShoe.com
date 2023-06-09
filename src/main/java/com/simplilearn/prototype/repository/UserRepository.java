package com.simplilearn.prototype.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.simplilearn.prototype.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> getUserByUsername(String username);
	public User getUserByEmailId(String emailId);
	public User getUserByContactNo(String contactNo);

}
