package com.bd.eshopper.locationVoiture.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode1;


public interface AcrissCarCode1Repository extends JpaRepository<AcrissCarCode1, String> {

	@Query("select a from AcrissCarCode1 a where a.code = :code and a.categorie = :categorie" )
	List<AcrissCarCode1> findByCodeAndCategorie(@Param(value = "code") String code , @Param(value = "categorie") String categorie);
	

}
