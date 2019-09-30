package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class CompagnieVehicule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	@NotNull
	@Size(min= 2 ,max = 100, message="indiquez le nom ")
	private String nom ;
	
	@OneToMany(mappedBy="compagnie" )
	//@JsonManagedReference
	@JsonIgnoreProperties("compagnie")
	private List<AgenceAuto> agences ;
	
	public CompagnieVehicule() {

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
	
	//@JsonIgnore
	public List<AgenceAuto> getAgences() {
		return agences;
	}
	
	//@JsonSetter
	public void setAgences(List<AgenceAuto> agences) {
		this.agences = agences;
	}
	

}
