package com.simplilearn.prototype.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simplilearn.prototype.model.Admin;
import com.simplilearn.prototype.model.Product;

@Service
public interface AdminService {
	
	List<Admin> getAllAdmins();
	Admin addAdmin(Admin admin);
	Admin findAdminById(int id);
	List<Admin> findByUsername(String username);
	void updateAdmin(Integer id, Admin admin);
	List<Admin> getAdminByEmailId(String emailId);	
	void deleteAdmin(int id);

}
