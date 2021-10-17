package com.hcl.cs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="login11")
public class Login {
    @Id
    @NotEmpty(message="Please Enter Name")
	private String userName;
    @NotEmpty(message="please Enter Password")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Login() {
		super();
		
	}
	
}