package com.bd.eshopper.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.eshopper.service.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
