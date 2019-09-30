package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PrixVehicule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition ="Decimal(10,2)" ,scale=2)   //@Column(columnDefinition ="Decimal(10,2)") @Column(precision=10 , scale=2)
	@DecimalMin("10.0")
	private Double montant;

	private Date createdAt;

	@ManyToOne
	@JoinColumn(name = "devis_id")
	private Devis devis;
	
	@ManyToOne
	@JoinColumn(name = "tarifsVehicule_id")
	private TarifsVehicule tarifsVehicule;

	@ManyToOne
	@JoinColumn(name = "vehicule_id")
	private Vehicule vehicule;

	public PrixVehicule() {
		this.createdAt = new Date();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Devis getDevis() {
		return devis;
	}
	
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = new Date();
	}

	public TarifsVehicule getTarifsVehicule() {
		return tarifsVehicule;
	}

	public void setTarifsVehicule(TarifsVehicule tarifsVehicule) {
		this.tarifsVehicule = tarifsVehicule;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	
	
	

}
