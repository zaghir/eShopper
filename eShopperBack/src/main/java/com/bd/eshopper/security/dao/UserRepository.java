package com.bd.eshopper.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.eshopper.security.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	

}
