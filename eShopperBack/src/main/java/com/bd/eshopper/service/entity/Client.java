package com.bd.eshopper.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bd.eshopper.security.entity.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Client implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 100, message = "indiquez le nom")
    private String nom;
    @NotNull
    @Size(min = 2, max = 100, message = "indiquez le prenom")
    private String prenom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @NotNull
    @Size(min = 2, message = "indiquez l'adresse")
    private String adresse;
    @NotNull
    @Size(min = 2, max = 100, message = "indiquez la ville")
    private String ville;
    @NotNull
    @Size(min = 2, max = 6, message = "indiquez le code postal")
    private String codePostal;
    @NotNull
    @Size(min = 2, max = 100, message = "indiquez le pays")
    private String pays;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    private String email;
    private String telephone;
    private Date createdAt;
    private Date updatedAt;
    private String numeroCb;
    private String moisCb;
    private String anneeCb;
    private String cryptogrameCb;
    
    @OneToMany(mappedBy="client")
    private List<Reservation> reservations ;    
   
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Client() {
        this.createdAt = new Date();

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNumeroCb() {
        return numeroCb;
    }

    public void setNumeroCb(String numeroCb) {
        this.numeroCb = numeroCb;
    }

    public String getMoisCb() {
        return moisCb;
    }

    public void setMoisCb(String moisCb) {
        this.moisCb = moisCb;
    }

    public String getAnneeCb() {
        return anneeCb;
    }

    public void setAnneeCb(String anneeCb) {
        this.anneeCb = anneeCb;
    }

    public String getCryptogrameCb() {
        return cryptogrameCb;
    }

    public void setCryptogrameCb(String cryptogrameCb) {
        this.cryptogrameCb = cryptogrameCb;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
    
    
}
