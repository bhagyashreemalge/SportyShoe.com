package com.simplilearn.prototype.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.prototype.model.Admin;
import com.simplilearn.prototype.model.Product;
import com.simplilearn.prototype.model.User;
import com.simplilearn.prototype.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminrepository;

	@Override
	public List<Admin> getAllAdmins() {
		return (List<Admin>) adminrepository.findAll();
	}

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminrepository.save(admin);
	}
	
	public Admin findAdminById(int id)
	{
		return adminrepository.findById(id).get();
	}
	
	public List<Admin> findByUsername(String username)
	{
		return  ((Collection<Admin>) adminrepository.findAll()).stream().filter(i->i.getEmailId().equalsIgnoreCase(username)).collect(Collectors.toList());
	}
	
	public void updateAdmin(Integer id, Admin admin) {
		Admin newAdmin = adminrepository.findById(id).get();
		newAdmin.setUsername(admin.getUsername());
		newAdmin.setEmailId(admin.getEmailId());
		newAdmin.setPassword(admin.getPassword());
		newAdmin.setContactNo(admin.getContactNo());
		adminrepository.save(newAdmin);
	}
	
	public List<Admin> getAdminByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return ((Collection<Admin>) adminrepository.findAll()).stream().filter(i->i.getEmailId().equalsIgnoreCase(emailId)).collect(Collectors.toList());
	}

	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		adminrepository.deleteById(id);
	}
	
	
}
