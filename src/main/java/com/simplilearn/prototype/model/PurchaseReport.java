package com.simplilearn.prototype.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table
public class PurchaseReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@OneToOne(mappedBy = "User")
	@Column
	//@Autowired
	private String user;
	//@OneToMany(mappedBy = "Product")
	@Column
	//@Autowired
	private String product;
	//private List<Product> products;
	@Column
	private int qty;
	@Column
	private int price;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateofpurchase;
	
	public PurchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseReport(int id, String user, String product, int qty, int price, Date dateofpurchase) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.qty = qty;
		this.price = price;
		this.dateofpurchase = dateofpurchase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDateofpurchase() {
		return dateofpurchase;
	}

	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	@Override
	public String toString() {
		return "PurchaseReport [id=" + id + ", user=" + user + ", product=" + product + ", qty=" + qty + ", price="
				+ price + ", dateofpurchase=" + dateofpurchase + "]";
	}
		
}