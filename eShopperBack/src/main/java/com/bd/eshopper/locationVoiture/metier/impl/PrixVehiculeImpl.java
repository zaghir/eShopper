package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.PrixVehiculeRepository;
import com.bd.eshopper.locationVoiture.entity.PrixVehicule;
import com.bd.eshopper.locationVoiture.metier.PrixVehiculeMetier;

@Service
public class PrixVehiculeImpl implements PrixVehiculeMetier {

	@Autowired
	private PrixVehiculeRepository prixRepository;

	@Override
	public PrixVehicule save(PrixVehicule o) {
		return prixRepository.save(o);
	}

	@Override
	public List<PrixVehicule> getAll() {
		return prixRepository.findAll();
	}

	@Override
	public PrixVehicule update(PrixVehicule o) {
		return prixRepository.save(o);
	}

	@Override
	public Long delete(Long id) {

		prixRepository.delete(id);
		return id;

	}

	@Override
	public PrixVehicule findOne(Long id) {
		return prixRepository.findOne(id);
	}


}
