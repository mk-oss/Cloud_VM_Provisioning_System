package com.mk.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

  
@Entity
@Table(name = "user")
@XmlRootElement(name = "customer")
public class user implements java.io.Serializable{
	
	private String userName;
	private String password;

	public user() {
	}
 
	public user(String username, String password) {
 		this.userName = username;
		this.password = password;
	}
   
	@XmlElement
	@Id
	@Column(name = "username", unique = true,nullable = false, length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement
	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
