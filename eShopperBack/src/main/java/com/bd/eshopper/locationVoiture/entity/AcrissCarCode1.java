package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AcrissCarCode1 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Size( min=1 ,max=3 , message=" indiquez le code"  )
	private String code ;
	
	@NotNull
	@Size(min=2 , message ="indiquez la categorie " , max = 50)
	private String categorie ;
	
	public AcrissCarCode1() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	

}
