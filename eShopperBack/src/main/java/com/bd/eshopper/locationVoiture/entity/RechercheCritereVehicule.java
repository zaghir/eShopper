package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;

public class RechercheCritereVehicule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String datePret ;
	 private String dateRetour ;
	 private Integer heurePret ;
	 private Integer heureRetour ;
	 private String categorie ;
	 private String transmissionDrive ;
	 private String typeVehicule ;
	public String getDatePret() {
		return datePret;
	}
	public void setDatePret(String datePret) {
		this.datePret = datePret;
	}
	public String getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}
	public Integer getHeurePret() {
		return heurePret;
	}
	public void setHeurePret(Integer heurePret) {
		this.heurePret = heurePret;
	}
	public Integer getHeureRetour() {
		return heureRetour;
	}
	public void setHeureRetour(Integer heureRetour) {
		this.heureRetour = heureRetour;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getTransmissionDrive() {
		return transmissionDrive;
	}
	public void setTransmissionDrive(String transmissionDrive) {
		this.transmissionDrive = transmissionDrive;
	}
	public String getTypeVehicule() {
		return typeVehicule;
	}
	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	 
	 

}
