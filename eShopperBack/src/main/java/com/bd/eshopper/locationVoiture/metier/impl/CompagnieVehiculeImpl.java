package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.CompagnieVehiculeRepository;
import com.bd.eshopper.locationVoiture.entity.CompagnieVehicule;
import com.bd.eshopper.locationVoiture.metier.CompagnieVehiculeMetier;

@Service
public class CompagnieVehiculeImpl implements CompagnieVehiculeMetier {

	@Autowired
	private CompagnieVehiculeRepository compagineVehiculeRepository;

	@Override
	public CompagnieVehicule save(CompagnieVehicule o) {
		CompagnieVehicule a = new CompagnieVehicule();		
		if (o.getId() == null) {
			if (o.getNom() != null) {
				if (compagineVehiculeRepository.findByNom(o.getNom()) == null) {
					a = compagineVehiculeRepository.save(o);
				} else {
					a.setNom("exite deja");
				}
			}
		}
		return a;
	}

	@Override
	public List<CompagnieVehicule> getAll() {
		return compagineVehiculeRepository.findAll();
	}

	@Override
	public CompagnieVehicule upadete(CompagnieVehicule o) {
		return compagineVehiculeRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		if (compagineVehiculeRepository.findOne(id) != null) {
			compagineVehiculeRepository.delete(id);
			return id;
		} else {
			return 0L;
		}
	}

	@Override
	public CompagnieVehicule findOne(Long id) {
		return compagineVehiculeRepository.findOne(id);
	}

}
