package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.AcrissCarCode3Repository;
import com.bd.eshopper.locationVoiture.entity.AcrissCarCode3;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode3Metier;

@Service
public class AcrissCarCode3Impl implements AcrissCarCode3Metier {
	
	@Autowired
	private AcrissCarCode3Repository acrissCarCode3Repository;

	@Override
	public AcrissCarCode3 save(AcrissCarCode3 o) {
		AcrissCarCode3 a = new AcrissCarCode3() ;
		if(acrissCarCode3Repository.findOne(o.getCode()) == null){
			return acrissCarCode3Repository.save(o);
		}else{
			 a.setDrive("existe deja"); 
			 a.setTransmission("existe deja");
			 return a;
		}			
	}

	@Override
	public List<AcrissCarCode3> getAll() {
		return acrissCarCode3Repository.findAll();
	}

	@Override
	public AcrissCarCode3 update(AcrissCarCode3 o) {
		return acrissCarCode3Repository.save(o);
	}

	@Override
	public String delete(String code) {
		if (acrissCarCode3Repository.findOne(code) != null) {
			acrissCarCode3Repository.delete(code);
		}
		return code ;
	}

	@Override
	public AcrissCarCode3 findOne(String code) {
		return acrissCarCode3Repository.findOne(code);
	}
	
	

}
