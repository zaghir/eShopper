package com.bd.eshopper.hotel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Chambre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numeroChambre;
	private int nbLitsSimples;
	private int nbLitsDoubles;
	private Long prixJournee;
	
	@ManyToOne
	private ReservationHotel reservationHotel;
	
	@ManyToOne
	private Hotel hotel;

	
	public Chambre() {
		super();
	}


	public Chambre(int numeroChambre, int nbLitsSimples, int nbLitsDoubles, Long prixJournee) {
		super();
		this.numeroChambre = numeroChambre;
		this.nbLitsSimples = nbLitsSimples;
		this.nbLitsDoubles = nbLitsDoubles;
		this.prixJournee = prixJournee;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumeroChambre() {
		return numeroChambre;
	}


	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}


	public int getNbLitsSimples() {
		return nbLitsSimples;
	}


	public void setNbLitsSimples(int nbLitsSimples) {
		this.nbLitsSimples = nbLitsSimples;
	}


	public int getNbLitsDoubles() {
		return nbLitsDoubles;
	}


	public void setNbLitsDoubles(int nbLitsDoubles) {
		this.nbLitsDoubles = nbLitsDoubles;
	}


	public Long getPrixJournee() {
		return prixJournee;
	}


	public void setPrixJournee(Long prixJournee) {
		this.prixJournee = prixJournee;
	}


	public ReservationHotel getReservationHotel() {
		return reservationHotel;
	}


	public void setReservationHotel(ReservationHotel reservationHotel) {
		this.reservationHotel = reservationHotel;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	@Override
	public String toString() {
		return "Chambre [id=" + id + ", numeroChambre=" + numeroChambre + ", nbLitsSimples=" + nbLitsSimples
				+ ", nbLitsDoubles=" + nbLitsDoubles + ", prixJournee=" + prixJournee + ", reservationHotel="
				+ reservationHotel + ", hotel=" + hotel + "]";
	}
	
	
	
	

}
