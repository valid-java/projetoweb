package com.sgpvalid.admin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login  implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String user;
	private String userName;
	private String password;
	private Boolean administrator;
	private Boolean conventionalUser;
	private String departamento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
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
	public Boolean getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}
	public Boolean getConventionalUser() {
		return conventionalUser;
	}
	public void setConventionalUser(Boolean conventionalUser) {
		this.conventionalUser = conventionalUser;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
