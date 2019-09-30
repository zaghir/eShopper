package com.bd.eshopper.avion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bd.eshopper.train.entity.Trajet;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class CompagnieAerienne implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String airlineName;
        private String iataDesignator;
        private String digitCode;
        private String icaoDesignator;
        private String country;

    public CompagnieAerienne() {
    }

    public CompagnieAerienne(String airlineName, String iataDesignator, String digitCode, String icaoDesignator, String country) {
        this.airlineName = airlineName;
        this.iataDesignator = iataDesignator;
        this.digitCode = digitCode;
        this.icaoDesignator = icaoDesignator;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getIataDesignator() {
        return iataDesignator;
    }

    public void setIataDesignator(String iataDesignator) {
        this.iataDesignator = iataDesignator;
    }

    public String getDigitCode() {
        return digitCode;
    }

    public void setDigitCode(String digitCode) {
        this.digitCode = digitCode;
    }

    public String getIcaoDesignator() {
        return icaoDesignator;
    }

    public void setIcaoDesignator(String icaoDesignator) {
        this.icaoDesignator = icaoDesignator;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CompagnieAerienne{" + "id=" + id + ", airlineName=" + airlineName + ", iataDesignator=" + iataDesignator + ", digitCode=" + digitCode + ", icaoDesignator=" + icaoDesignator + ", country=" + country + '}';
    }
}