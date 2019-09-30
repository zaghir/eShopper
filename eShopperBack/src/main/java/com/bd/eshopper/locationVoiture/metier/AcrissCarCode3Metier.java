package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode3;

public interface AcrissCarCode3Metier {
	
	public AcrissCarCode3 save(AcrissCarCode3 o) ;
	public List<AcrissCarCode3> getAll();
	public AcrissCarCode3 update(AcrissCarCode3 o) ;
	public String delete(String code) ;
	public AcrissCarCode3 findOne(String code) ;

}
