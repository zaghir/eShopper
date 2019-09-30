package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Clique implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@ManyToOne
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule ;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdAt ;
	
	public Clique() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
