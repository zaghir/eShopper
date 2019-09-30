package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class AgenceAuto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id ;
	
	@NotNull
	@Size(min =2 , max=100 , message=" indiquez le nom ")
	private String nom ;
	
	@NotNull(message=" indiquez l'adresse ")
	private String adresse ;	
	
	@NotNull(message=" indiquez la ville ")
	private String ville ;
	
	@NotNull(message=" indiquez le pays ")
	private String pays ;
	
	//@Column( nullable = false )
	@NotNull( message=" indiquez latitude ")
	private Double latitudeLocation ;
	
	@NotNull(message=" indiquez longitude ")
	private Double longitudeLocation ;
	
//	@NotNull
//	@Size(min =2 , message=" indiquez l'airoport ")
//	@ManyToOne
//	@JoinColumn(name="airoport_id")
//	private Airoport airoport ;
	
	
	@NotNull( message=" indiquez compagnie ")
	@ManyToOne
	@JoinColumn(name="compagnie_id")
	//@JsonBackReference
	private CompagnieVehicule compagnie ;
	
	public AgenceAuto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
//	@JsonIgnore
//	public Airoport getAiroport() {
//		return airoport;
//	}
//
//	@JsonSetter
//	public void setAiroport(Airoport airoport) {
//		this.airoport = airoport;
//	}

	public Double getLatitudeLocation() {
		return latitudeLocation;
	}

	public void setLatitudeLocation(Double latitudeLocation) {
		this.latitudeLocation = latitudeLocation;
	}

	public Double getLongitudeLocation() {
		return longitudeLocation;
	}

	public void setLongitudeLocation(Double longitudeLocation) {
		this.longitudeLocation = longitudeLocation;
	}

	//@JsonIgnore
	public CompagnieVehicule getCompagnie() {
		return compagnie;
	}

	//@JsonSetter
	public void setCompagnie(CompagnieVehicule compagnie) {
		this.compagnie = compagnie;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	
}
