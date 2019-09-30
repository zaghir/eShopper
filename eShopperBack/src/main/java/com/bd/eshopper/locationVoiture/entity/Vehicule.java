package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Vehicule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	private String immatriculation ;
	
	@NotNull
	@Size(min=2 , message="indiquez le Numéro Serie ")
	private String numeroSerie ;
	
	private String nom ;
	
	private String acrissCode ;
	private Boolean reserver ;
	
	@ManyToOne
	@JoinColumn(name="acrissCarCode1_id")
	private AcrissCarCode1 acrissCarCode1 ;
	
	@ManyToOne
	@JoinColumn(name="acrissCarCode2_id")
	private AcrissCarCode2 acrissCarCode2 ;
	
	@ManyToOne
	@JoinColumn(name="acrissCarCode3_id")
	private AcrissCarCode3 acrissCarCode3 ;
	
	@ManyToOne
	@JoinColumn(name="acrissCarCode4_id")
	private AcrissCarCode4 acrissCarCode4 ;
	
	@OneToMany(mappedBy="vehicule" , cascade=CascadeType.ALL, orphanRemoval = true)
	private List<PrixVehicule> prixVehicule ;
	
	@ManyToOne
	@JoinColumn(name="agence_id")
	private AgenceAuto agence ;
	
	@OneToMany(mappedBy="vehicule")
	private List<Clique> cliques ;
	
	@OneToMany(mappedBy="vehicule")
	private List<Image> images ;
	
	@OneToMany(mappedBy="vehicule")
	private List<EstimationTotal> estimationTotals ;
	
	public Vehicule() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAcrissCode() {
		return acrissCode;
	}


	public void setAcrissCode(String acrissCode) {
		this.acrissCode = acrissCode;
	}


	public Boolean getReserver() {
		return reserver;
	}

	public void setReserver(Boolean reserver) {
		this.reserver = reserver;
	}


	public AcrissCarCode1 getAcrissCarCode1() {
		return acrissCarCode1;
	}


	public void setAcrissCarCode1(AcrissCarCode1 acrissCarCode1) {
		this.acrissCarCode1 = acrissCarCode1;
	}


	public AcrissCarCode2 getAcrissCarCode2() {
		return acrissCarCode2;
	}


	public void setAcrissCarCode2(AcrissCarCode2 acrissCarCode2) {
		this.acrissCarCode2 = acrissCarCode2;
	}


	public AcrissCarCode3 getAcrissCarCode3() {
		return acrissCarCode3;
	}


	public void setAcrissCarCode3(AcrissCarCode3 acrissCarCode3) {
		this.acrissCarCode3 = acrissCarCode3;
	}


	public AcrissCarCode4 getAcrissCarCode4() {
		return acrissCarCode4;
	}


	public void setAcrissCarCode4(AcrissCarCode4 acrissCarCode4) {
		this.acrissCarCode4 = acrissCarCode4;
	}


	public AgenceAuto getAgence() {
		return agence;
	}


	public void setAgence(AgenceAuto agence) {
		this.agence = agence;
	}

	@JsonIgnore
	public List<Clique> getCliques() {
		return cliques;
	}

	@JsonSetter
	public void setCliques(List<Clique> cliques) {
		this.cliques = cliques;
	}

	@JsonIgnore
	public List<Image> getImages() {
		return images;
	}

	@JsonSetter
	public void setImages(List<Image> images) {
		this.images = images;
	}

	@JsonIgnore
	public List<EstimationTotal> getEstimationTotals() {
		return estimationTotals;
	}

	@JsonSetter
	public void setEstimationTotals(List<EstimationTotal> estimationTotals) {
		this.estimationTotals = estimationTotals;
	}

	public List<PrixVehicule> getPrixVehicule() {
		return prixVehicule;
	}
	
	public void setPrixVehicule(List<PrixVehicule> prixVehicule) {
		this.prixVehicule = prixVehicule;
	}

	
		
	
}
