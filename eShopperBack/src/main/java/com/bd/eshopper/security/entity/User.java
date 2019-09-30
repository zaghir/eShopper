package com.bd.eshopper.security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.bd.eshopper.service.entity.Client;

@Entity(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String username ;
	private String password ;
	private boolean actived ;
	
	@OneToOne(mappedBy="user")
	private Client client ;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="USERS_ROLES" )
	private List<Role> roles ;
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
