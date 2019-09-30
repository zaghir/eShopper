package com.bd.eshopper.locationVoiture.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.locationVoiture.entity.AgenceAuto;

public interface AgenceAutoRepository extends JpaRepository<AgenceAuto, Long>{
	
	//@Query("select a.id , a.nom , a.adresse , a.ville , a.pays , a.latitudeLocation , a.compagnie.id , a.compagnie.nom  from  AgenceAuto a   order by a.nom")
	//public List<AgenceAuto> getListAgenceAuto();
	
	@Query("select a from AgenceAuto a where a.nom like :nom")
	public AgenceAuto findByNom(@Param(value="nom") String nom);
		

}
