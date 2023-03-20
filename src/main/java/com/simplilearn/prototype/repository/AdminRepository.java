package com.simplilearn.prototype.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.prototype.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {


}
