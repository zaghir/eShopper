package com.bd.eshopper.avion.metier;

import com.bd.eshopper.avion.entity.ReservationVol;
import java.util.List;


public interface ReservationVolMetier {
	
	public ReservationVol findOne(Long id) ;
	public List<ReservationVol> getAll();
	public ReservationVol save(ReservationVol o) ;
	public ReservationVol update(ReservationVol o) ;
	public String delete(Long id) ;
	

}
