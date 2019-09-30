package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.ReservationVehicule;

public interface ReservationVehiculeMetier {
	public ReservationVehicule save(ReservationVehicule o) ;
	public List<ReservationVehicule> getAll();
	public Long delete(Long id );
	public ReservationVehicule update(ReservationVehicule o );
	public ReservationVehicule findOne(Long id) ;	
	public ReservationVehicule getReservationByCode(String id);
	
}
