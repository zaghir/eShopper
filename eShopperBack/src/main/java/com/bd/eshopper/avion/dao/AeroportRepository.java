package com.bd.eshopper.avion.dao;

import com.bd.eshopper.avion.entity.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AeroportRepository extends JpaRepository<Aeroport, Long>{
	
	@Query("select a from Aeroport a where a.code = :code")
	public Aeroport findByCode(@Param(value = "code") String code) ;

}
