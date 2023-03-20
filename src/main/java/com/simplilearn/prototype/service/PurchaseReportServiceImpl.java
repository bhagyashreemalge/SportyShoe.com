package com.simplilearn.prototype.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.prototype.model.Product;
import com.simplilearn.prototype.model.PurchaseReport;
import com.simplilearn.prototype.repository.ProductRepository;
import com.simplilearn.prototype.repository.PurchaseReportRepository;

@Service
public class PurchaseReportServiceImpl implements PurchaseReportService{
	
	@Autowired
	PurchaseReportRepository purchaserepository;
	
	@Autowired
	ProductRepository productrepository;

	@Override
	public List<PurchaseReport> getPurchaseReportByDOP(Date dateofpurchase) {
		// TODO Auto-generated method stub
		List<PurchaseReport> purchasereports =  ((Collection<PurchaseReport>) purchaserepository.findAll()).stream().filter(i -> i.getDateofpurchase()==dateofpurchase).collect(Collectors.toList());
		return purchasereports;
	}

	@Override
	public List<PurchaseReport> getallPurchaseReports() {
		// TODO Auto-generated method stub
		return (List<PurchaseReport>) purchaserepository.findAll();
	}
	
	public PurchaseReport getPurchaseReportById(int id)
	{
		return purchaserepository.findById(id).get();
	}
	
	public void deletePurchaseReportById(int id)
	{
		purchaserepository.deleteById(id);
	}

	@Override
	public PurchaseReport createPurchaseReport(PurchaseReport purchasereport) {
		// TODO Auto-generated method stub
		return purchaserepository.save(purchasereport);
	}

	@Override
	public List<PurchaseReport> getPurchaseReportByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> products = ((Collection<Product>) productrepository.findAll()).stream().filter(i -> i.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		List<PurchaseReport> purchaseReports = (List<PurchaseReport>) purchaserepository.findAll();
		List<String> cproductnames=new ArrayList<>();
		for(Product eachproduct:products)
		{
			cproductnames.add(eachproduct.getName());
		}
		List<PurchaseReport> cpurchasereports=new ArrayList<>();
		/*for(PurchaseReport eachpurchreport:purchaseReports)
		{
			List<Product> product2=eachpurchreport.getProduct();
			//List<Integer> productid2=new ArrayList<>();
			for(Product eachofproduct:product2) {
				//productid2.add(eachofproduct.getId());
				//if(productids.contains(productid2))
				if(productids.contains(eachofproduct.getId())){
					cpurchasereports.add(eachpurchreport);
				}
			}
			
		}*/
		for(PurchaseReport eachpurchasereport:purchaseReports)
		{
			String[] purchasereportProducts=eachpurchasereport.getProduct().split(" ");
			List<String> reportproductslist = Arrays.asList(purchasereportProducts);
			
			if(cproductnames.contains(reportproductslist))
			{
				cpurchasereports.add(eachpurchasereport);
			}
		}
		
		return cpurchasereports;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<PurchaseReport> getPurchaseReportByCategoryandDOP(String category, Date dop) {
		// TODO Auto-generated method stub
		List<Product> products = ((Collection<Product>) productrepository.findAll()).stream().filter(i -> i.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		List<PurchaseReport> purchaseReports = (List<PurchaseReport>) purchaserepository.findAll();
		List<String> cproductnames=new ArrayList<>();
		for(Product eachproduct:products)
		{
			cproductnames.add(eachproduct.getName());
		}
		List<PurchaseReport> cpurchasereports=new ArrayList<>();
		/*for(PurchaseReport eachpurchreport:purchaseReports)
		{
			List<Product> product2=eachpurchreport.getProduct();
			//List<Integer> productid2=new ArrayList<>();
			for(Product eachofproduct:product2) {
				//productid2.add(eachofproduct.getId());
				//if(productids.contains(productid2))
				if(productids.contains(eachofproduct.getId())){
					cpurchasereports.add(eachpurchreport);
				}
			}
			
		}*/
		for(PurchaseReport eachpurchasereport:purchaseReports)
		{
			String[] purchasereportProducts=eachpurchasereport.getProduct().split(" ");
			List<String> reportproductslist = Arrays.asList(purchasereportProducts);
			
			if(cproductnames.contains(reportproductslist))
			{
				cpurchasereports.add(eachpurchasereport);
			}
		}
		List<PurchaseReport> cAnddoppurchasereports=cpurchasereports.stream().filter(i->i.getDateofpurchase().equals(dop)).collect(Collectors.toList());
		
		return cAnddoppurchasereports;
	}
	

	public void updatePurchaseReport(Integer id, PurchaseReport purchasereport) {
		PurchaseReport newPurchasereport = purchaserepository.findById(id).get();
		newPurchasereport.setDateofpurchase(purchasereport.getDateofpurchase());
		newPurchasereport.setPrice(purchasereport.getPrice());
		newPurchasereport.setProduct(purchasereport.getProduct());
		newPurchasereport.setQty(purchasereport.getQty());
		newPurchasereport.setUser(purchasereport.getUser());
		purchaserepository.save(newPurchasereport);
	}

}
