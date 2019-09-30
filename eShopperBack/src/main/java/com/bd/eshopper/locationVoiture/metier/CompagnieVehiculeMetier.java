package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.CompagnieVehicule;

public interface CompagnieVehiculeMetier {

	public CompagnieVehicule save(CompagnieVehicule o) ;
	public List<CompagnieVehicule> getAll();
	public CompagnieVehicule upadete(CompagnieVehicule o) ;
	public Long delete(Long id ) ;
	public CompagnieVehicule findOne(Long id) ;
	
}
