package com.bd.eshopper.avion.entity;

import com.bd.eshopper.avion.entity.TerminalAero;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aeroport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id  ;
	@NotNull
	@Size(min=2 ,max = 100 , message="indiquez le code de l'airport")
	private String code ;
	@NotNull
	@Size(min=2 , message="indiquez l'adresse")
	private String adresse ;
	@NotNull
	@Size(min=2 , max = 100, message="indiquez la ville")
	private String ville ;
	@NotNull
	@Size(min=2 , max = 100, message="indiquez le pays")
	private String pays ;
        
	@OneToMany
        @JoinColumn(name="airport_id")
        private List<TerminalAero> terminalAero ;
	
	public Aeroport() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

//	@JsonIgnore
//	public List<AgenceAuto> getAgences() {
//		return agences;
//	}
//
//	@JsonSetter
//	public void setAgences(List<AgenceAuto> agences) {
//		this.agences = agences;
//	}
	
	
	

}
