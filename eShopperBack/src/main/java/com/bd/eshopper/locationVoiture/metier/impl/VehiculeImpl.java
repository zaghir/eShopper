package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.VehiculeRepository;
import com.bd.eshopper.locationVoiture.entity.RechercheCritereVehicule;
import com.bd.eshopper.locationVoiture.entity.Vehicule;
import com.bd.eshopper.locationVoiture.metier.VehiculeMetier;

@Service
public class VehiculeImpl  implements VehiculeMetier{
	
	@Autowired
	private VehiculeRepository vehiculeRepository;

	@Override
	public Vehicule save(Vehicule o) {
		return  vehiculeRepository.save(o) ; 
	}

	@Override
	public List<Vehicule> getAll() {
		return vehiculeRepository.findAll();
	}

	@Override
	public Vehicule update(Vehicule o) {
		return vehiculeRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		Vehicule v = null ;
		Long identif =0L ;
		v = vehiculeRepository.getOne(id);
		
		if( v != null){
			//vehiculeRepository.deletePrixVehicule(id);
			vehiculeRepository.delete(id);
			identif= id ;
		}
		return identif ;
	}

	@Override
	public Vehicule findOne(Long id) {
		return vehiculeRepository.findOne(id);
	}

	@Override
	public List<Vehicule> rechercheVehiculePourLocation(RechercheCritereVehicule o) {
		
		//return vehiculeRepository.rechercheVehiculePourLocation(o.getCategorie(), o.getTypeVehicule(), o.getTransmissionDrive());
		return vehiculeRepository.rechercheVehiculePourLocation(o.getCategorie() , o.getTypeVehicule() , o.getTransmissionDrive());
	}
	

}
