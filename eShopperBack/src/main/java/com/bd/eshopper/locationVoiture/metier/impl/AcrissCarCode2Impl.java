package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.AcrissCarCode2Repository;
import com.bd.eshopper.locationVoiture.entity.AcrissCarCode2;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode2Metier;

@Service
public class AcrissCarCode2Impl implements AcrissCarCode2Metier{
	
	@Autowired
	private AcrissCarCode2Repository acrissCarCode2Repositorie ;

	@Override
	public AcrissCarCode2 save(AcrissCarCode2 o) {
		AcrissCarCode2 a = new AcrissCarCode2() ;
		if(acrissCarCode2Repositorie.findOne(o.getCode()) == null){
			return acrissCarCode2Repositorie.save(o);
		}else{
			 a.setTypeVehicule("existe deja"); 
			 return a;
		}	
	}

	@Override
	public List<AcrissCarCode2> getAll() {
		return acrissCarCode2Repositorie.findAll();
	}

	@Override
	public AcrissCarCode2 update(AcrissCarCode2 o) {
		return acrissCarCode2Repositorie.save(o);
	}

	@Override
	public String delete(String code) {
		if (acrissCarCode2Repositorie.findOne(code) != null) {
			acrissCarCode2Repositorie.delete(code);
		}
		return code ;
	}


	@Override
	public AcrissCarCode2 findOne(String code) {
		return acrissCarCode2Repositorie.findOne(code);
	}

	
	

}
