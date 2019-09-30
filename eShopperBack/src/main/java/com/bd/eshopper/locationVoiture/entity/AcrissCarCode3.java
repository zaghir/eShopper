package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AcrissCarCode3 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Size( min=1, max=3 , message=" indiquez le code"  )
	private String code ;
	
	@NotNull
	@Size(min=2 , message ="indiquez transmission" , max= 50)
	private String transmission ;
	
	@NotNull
	@Size(min=2 , max=50 , message="indiquez drive")
	private String drive ;
	
	public AcrissCarCode3() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}
	
	

}
