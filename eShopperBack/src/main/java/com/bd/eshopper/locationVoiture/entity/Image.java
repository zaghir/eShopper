package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Image implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String urlImg ;
	private Integer widthImg ;
	private Integer heightImg ;
	private String categorieImg ;
	
	@ManyToOne
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule ;
	
	public Image() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	
	public Integer getWidthImg() {
		return widthImg;
	}

	public void setWidthImg(Integer widthImg) {
		this.widthImg = widthImg;
	}

	public Integer getHeightImg() {
		return heightImg;
	}

	public void setHeightImg(Integer heightImg) {
		this.heightImg = heightImg;
	}

	public String getCategorieImg() {
		return categorieImg;
	}

	public void setCategorieImg(String categorieImg) {
		this.categorieImg = categorieImg;
	}

	@JsonIgnore
	public Vehicule getVehicule() {
		return vehicule;
	}

	@JsonSetter
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	

}
