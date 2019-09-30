package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode1;

public interface AcrissCarCode1Metier {
	
	public AcrissCarCode1 save(AcrissCarCode1 o) ;
	public List<AcrissCarCode1> getAll();
	public AcrissCarCode1 update(AcrissCarCode1 o) ;
	public String delete(String code) ;
	public AcrissCarCode1 findOne(String code) ;
	

}
