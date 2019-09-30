package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode4;

public interface AcrissCarCode4Metier {
	
	public AcrissCarCode4 save(AcrissCarCode4 o) ;
	public List<AcrissCarCode4> getAll();
	public AcrissCarCode4 update(AcrissCarCode4 o) ;
	public String delete(String code) ;
	public AcrissCarCode4 findOne(String code) ;

}
