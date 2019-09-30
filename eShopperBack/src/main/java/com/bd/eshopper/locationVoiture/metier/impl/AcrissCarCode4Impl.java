package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.AcrissCarCode4Repository;
import com.bd.eshopper.locationVoiture.entity.AcrissCarCode4;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode4Metier;

@Service
public class AcrissCarCode4Impl implements AcrissCarCode4Metier{
	
	@Autowired
	private AcrissCarCode4Repository acrissCarCode4Repository ;

	@Override
	public AcrissCarCode4 save(AcrissCarCode4 o) {
		AcrissCarCode4 a = new AcrissCarCode4() ;
		if(acrissCarCode4Repository.findOne(o.getCode()) == null){
			return acrissCarCode4Repository.save(o);
		}else{
			 a.setAirCondition("existe deja"); 
			 a.setFuel("existe deja");
			 return a;
		}
	}

	@Override
	public List<AcrissCarCode4> getAll() {
		return acrissCarCode4Repository.findAll();
	}

	@Override
	public AcrissCarCode4 update(AcrissCarCode4 o) {
		return acrissCarCode4Repository.save(o);
	}

	@Override
	public String delete(String code) {
		if (acrissCarCode4Repository.findOne(code) != null) {
			acrissCarCode4Repository.delete(code);
		}
		return code ;
	}

	@Override
	public AcrissCarCode4 findOne(String code) {
		return acrissCarCode4Repository.findOne(code);
	}
	

}
