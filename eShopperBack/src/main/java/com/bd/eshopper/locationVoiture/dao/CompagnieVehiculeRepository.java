package com.bd.eshopper.locationVoiture.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.locationVoiture.entity.CompagnieVehicule;

public interface CompagnieVehiculeRepository extends JpaRepository<CompagnieVehicule, Long>{
	
	@Query("select c from CompagnieVehicule c where c.nom like :nom")
	public CompagnieVehicule findByNom(@Param(value = "nom") String nom ); 

}
