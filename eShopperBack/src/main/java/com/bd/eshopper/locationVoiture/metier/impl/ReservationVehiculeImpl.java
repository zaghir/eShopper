package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.ReservationVehiculeRepository;
import com.bd.eshopper.locationVoiture.entity.ReservationVehicule;
import com.bd.eshopper.locationVoiture.metier.ReservationVehiculeMetier;
import com.bd.eshopper.service.dao.ClientRepository;

@Service
public class ReservationVehiculeImpl implements ReservationVehiculeMetier {

	@Autowired
	private ReservationVehiculeRepository reservationVehiculeRepository;
	
	@Autowired
	private ClientRepository clientRepository ;

	@Override
	public ReservationVehicule save(ReservationVehicule o) {

		o.setClient(clientRepository.save(o.getClient()));
		o.setCodeReservation(reservationVehiculeRepository.generatCodeReservazation(o.getVehicule().getId())) ;		
		return reservationVehiculeRepository.save(o);

	}

	@Override
	public List<ReservationVehicule> getAll() {
		return reservationVehiculeRepository.findAll();
	}

	@Override
	public Long delete(Long id) {
		if (reservationVehiculeRepository.findOne(id) != null) {
			reservationVehiculeRepository.delete(id);
			return id;
		} else {
			return 0L;
		}
	}

	@Override
	public ReservationVehicule update(ReservationVehicule o) {
		return reservationVehiculeRepository.save(o);
	}

	@Override
	public ReservationVehicule findOne(Long id) {
		return reservationVehiculeRepository.findOne(id);
	}

	@Override
	public ReservationVehicule getReservationByCode(String id) {
		
		return reservationVehiculeRepository.getReservationByCode(id);
	}
	
	

}
