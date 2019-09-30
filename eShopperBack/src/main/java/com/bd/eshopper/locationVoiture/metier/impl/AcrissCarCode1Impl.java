package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.AcrissCarCode1Repository;
import com.bd.eshopper.locationVoiture.entity.AcrissCarCode1;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode1Metier;

@Service
public class AcrissCarCode1Impl implements AcrissCarCode1Metier {

	@Autowired
	private AcrissCarCode1Repository acrissCarCode1Repositorie;

	@Override
	public AcrissCarCode1 save(AcrissCarCode1 o) {
		AcrissCarCode1 a = new AcrissCarCode1();
		if (acrissCarCode1Repositorie.findOne(o.getCode()) == null) {
			return acrissCarCode1Repositorie.save(o);
		} else {
			a.setCategorie("existe deja");
			return a;
		}
	}

	@Override
	public List<AcrissCarCode1> getAll() {
		return acrissCarCode1Repositorie.findAll();
	}

	@Override
	public AcrissCarCode1 update(AcrissCarCode1 o) {
		return acrissCarCode1Repositorie.save(o);
	}

	@Override
	public String delete(String code) {
		if (acrissCarCode1Repositorie.findOne(code) != null) {
			acrissCarCode1Repositorie.delete(code);
		}
		return code ;
	}
	

	@Override
	public AcrissCarCode1 findOne(String code) {
		return acrissCarCode1Repositorie.findOne(code);
	}

}
