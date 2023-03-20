package com.simplilearn.prototype.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.prototype.model.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends CrudRepository<PurchaseReport, Integer>{

}
