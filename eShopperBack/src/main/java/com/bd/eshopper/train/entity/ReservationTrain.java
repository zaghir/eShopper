package com.bd.eshopper.train.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.bd.eshopper.service.entity.Reservation;
@Entity
public class ReservationTrain extends Reservation{
	@PrimaryKeyJoinColumn(name="RESERVATION_ID")
	private String typeSiege;
	private int nbPassagers;
	
	@OneToMany(mappedBy="reservationTrain")
	private List<Trajet> trajets;

	
	public ReservationTrain() {
		super();
	}

	public ReservationTrain(String typeSiege, int nbPassagers) {
		super();
		this.typeSiege = typeSiege;
		this.nbPassagers = nbPassagers;
	}

	public String getTypeSiege() {
		return typeSiege;
	}

	public void setTypeSiege(String typeSiege) {
		this.typeSiege = typeSiege;
	}

	public int getNbPassagers() {
		return nbPassagers;
	}

	public void setNbPassagers(int nbPassagers) {
		this.nbPassagers = nbPassagers;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	@Override
	public String toString() {
		return "ReservationTrain [typeSiege=" + typeSiege + ", nbPassagers=" + nbPassagers + ", trajets=" + trajets
				+ "]";
	}
	
	

}
