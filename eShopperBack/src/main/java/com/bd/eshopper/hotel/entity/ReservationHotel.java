package com.bd.eshopper.hotel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.bd.eshopper.service.entity.Reservation;
@Entity
public class ReservationHotel extends Reservation {
	@PrimaryKeyJoinColumn(name="RESERVATION_ID")
	
	private Date dateArrivee;
	private Date dateDepart;
	private boolean annulable;
	private boolean remboursable;
	
	@OneToMany(mappedBy="reservationHotel")
	private List<Chambre> chambres;

	public ReservationHotel(Date dateArrivee, Date dateDepart, boolean annulable, boolean remboursable) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.annulable = annulable;
		this.remboursable = remboursable;
	}
	
	

}
