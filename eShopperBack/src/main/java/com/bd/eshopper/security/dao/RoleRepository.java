package com.bd.eshopper.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.eshopper.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
