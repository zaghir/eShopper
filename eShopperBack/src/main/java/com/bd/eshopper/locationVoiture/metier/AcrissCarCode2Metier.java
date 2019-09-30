package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode2;

public interface AcrissCarCode2Metier {
	public AcrissCarCode2 save(AcrissCarCode2 o) ;
	public List<AcrissCarCode2> getAll();
	public AcrissCarCode2 update(AcrissCarCode2 o) ;
	public String delete(String code) ;
	public AcrissCarCode2 findOne(String code) ;
}
