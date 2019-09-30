package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.RechercheCritereVehicule;
import com.bd.eshopper.locationVoiture.entity.Vehicule;

public interface VehiculeMetier {
	
	public Vehicule save(Vehicule o);
	public List<Vehicule> getAll();
	public Vehicule update(Vehicule o) ;
	public Long delete(Long id) ;
	public Vehicule findOne(Long id ) ;
	
	public List<Vehicule> rechercheVehiculePourLocation(RechercheCritereVehicule o);

}
