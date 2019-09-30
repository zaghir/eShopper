package com.bd.eshopper.locationVoiture.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.locationVoiture.entity.ReservationVehicule;

public interface ReservationVehiculeRepository extends JpaRepository<ReservationVehicule, Long>{
	
	@Query("SELECT CONCAT ( 'RA-' , LPAD( :idVehicule ,6,'0') , '-', LPAD( max(r.id) + 1 ,7,'0')) as codeR from ReservationVehicule r ")	
	public String generatCodeReservazation(@Param(value="idVehicule") Long idVehicule) ;
	
	@Query("SELECT r FROM ReservationVehicule  r where r.codeReservation = :id ")
	public ReservationVehicule getReservationByCode(@Param(value="id")String id);

}
