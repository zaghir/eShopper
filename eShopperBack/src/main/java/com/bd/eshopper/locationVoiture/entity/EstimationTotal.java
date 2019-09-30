package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class EstimationTotal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@NotNull
	@Size(min=2 , message="indiquez le montant")
	private Double montant ;	
	
	@ManyToOne
	@JoinColumn(name="devis_id")
	private Devis devis ;
	
	@ManyToOne
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule ;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date createdAt ;
	
	public EstimationTotal() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@JsonIgnore
	public Devis getDevis() {
		return devis;
	}

	@JsonSetter
	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	@JsonIgnore
	public Vehicule getVehicule() {
		return vehicule;
	}

	@JsonSetter
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
