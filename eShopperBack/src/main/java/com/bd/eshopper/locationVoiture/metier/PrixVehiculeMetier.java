package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.PrixVehicule;

public interface PrixVehiculeMetier {
	
	public PrixVehicule save(PrixVehicule o) ;
	public List<PrixVehicule> getAll() ;
	public PrixVehicule update(PrixVehicule o);
	public Long delete(Long id);
	public PrixVehicule findOne(Long id);


}
