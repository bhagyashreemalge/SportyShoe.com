package com.simplilearn.prototype.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simplilearn.prototype.model.PurchaseReport;

@Service
public interface PurchaseReportService {
	
	List<PurchaseReport> getPurchaseReportByDOP(Date dateofpurchase);
	List<PurchaseReport> getallPurchaseReports();
	PurchaseReport createPurchaseReport(PurchaseReport purchasereport);
	List<PurchaseReport> getPurchaseReportByCategory(String category);
	List<PurchaseReport> getPurchaseReportByCategoryandDOP(String category,Date dop);
	PurchaseReport getPurchaseReportById(int id);
	void deletePurchaseReportById(int id);
	void updatePurchaseReport(Integer id, PurchaseReport purchasereport);

}
