package com.bd.eshopper.locationVoiture.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AcrissCarCode4 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Size( min=1 ,max=3 , message=" indiquez le code"  )
	private String code ;
	
	@NotNull
	@Size(min=2 , message =" indiquez le carburant " , max = 50)
	private String fuel ;
	
	@Size( max=50 , message=" indiquez le type de climatisation "  )
	private String airCondition ;
	
	public AcrissCarCode4() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getAirCondition() {
		return airCondition;
	}

	public void setAirCondition(String airCondition) {
		this.airCondition = airCondition;
	}
	
	

}
