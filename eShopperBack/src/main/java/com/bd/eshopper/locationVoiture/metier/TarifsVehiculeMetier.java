package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.TarifsVehicule;

public interface TarifsVehiculeMetier {
	
	public TarifsVehicule save(TarifsVehicule o) ;
	public List<TarifsVehicule> getAll();
	public TarifsVehicule update(TarifsVehicule o) ;
	public Long delete(Long id);
	public TarifsVehicule findOne(Long id) ;

}