package com.bd.eshopper.avion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroVol;
    private Date dateHeureDepart;
    private Date dateHeureArrivee;
    private String modelAvion;
    private String Classe;
    @ManyToOne(cascade = CascadeType.ALL)
    private CompagnieAerienne compagnieaerienne;
    @ManyToOne(cascade = CascadeType.ALL)
    private Aeroport aeroportDepart;
    @ManyToOne(cascade = CascadeType.ALL)
    private Aeroport aeroportArrivee;
    
    @ManyToMany(mappedBy="vols")
    List<ReservationVol> reservationVols;

    public Vol() {
    }

    public Vol(String numeroVol, Date dateHeureDepart, Date dateHeureArrivee, String modelAvion, String Classe, CompagnieAerienne compagnieaerienne, Aeroport aeroportDepart, Aeroport aeroportArrivee, List<ReservationVol> reservationVols) {
        this.numeroVol = numeroVol;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.modelAvion = modelAvion;
        this.Classe = Classe;
        this.compagnieaerienne = compagnieaerienne;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public Date getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(Date dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public Date getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public void setDateHeureArrivee(Date dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public String getModelAvion() {
        return modelAvion;
    }

    public void setModelAvion(String modelAvion) {
        this.modelAvion = modelAvion;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String Classe) {
        this.Classe = Classe;
    }

    public CompagnieAerienne getCompagnieaerienne() {
        return compagnieaerienne;
    }

    public void setCompagnieaerienne(CompagnieAerienne compagnieaerienne) {
        this.compagnieaerienne = compagnieaerienne;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public Aeroport getAeroportArrivee() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(Aeroport aeroportArrivee) {
        this.aeroportArrivee = aeroportArrivee;
    }
}
