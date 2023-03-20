package com.simplilearn.prototype.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String emailId;
	@Column
	private String password;
	@Column
	private String contactNo;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String emailId, String password, String contactNo) {
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.contactNo = contactNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", emailId=" + emailId + ", password=" + password
				+ ", contactNo=" + contactNo + "]";
	}
	

}
