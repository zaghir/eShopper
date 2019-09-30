package com.bd.eshopper.locationVoiture.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.locationVoiture.entity.TarifsVehicule;

public interface TarifsVehiculeRepository extends JpaRepository<TarifsVehicule, Long>{
	
	@Query("select t from TarifsVehicule t where t.type like :type")
	public TarifsVehicule findByTypeVehicule(@Param(value = "type") String type ); 

}
