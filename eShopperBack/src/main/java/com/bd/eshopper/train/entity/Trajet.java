package com.bd.eshopper.train.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trajet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numero;
    private Date dateHeureDepart;
    private Date dateHeureArrivee;
    private String classeVoyage;
    private String typeTrain;
    private int nbPlaces;
    @ManyToOne
    private ReservationTrain reservationTrain;
    @ManyToOne(cascade = CascadeType.ALL)
    private Gare gareDepart;
    @ManyToOne(cascade = CascadeType.ALL)
    private Gare gareArrivee;
    @ManyToOne(cascade = CascadeType.ALL)
    private CompagnieFerroviaire compagnieFerroviaire;

    public Trajet() {
        super();
    }

    public Trajet(int numero, Date dateHeureDepart, Date dateHeureArrivee, String classeVoyage, String typeTrain,
            int nbPlaces) {
        super();
        this.numero = numero;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.classeVoyage = classeVoyage;
        this.typeTrain = typeTrain;
        this.nbPlaces = nbPlaces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getClasseVoyage() {
        return classeVoyage;
    }

    public void setClasseVoyage(String classeVoyage) {
        this.classeVoyage = classeVoyage;
    }

    public String getTypeTrain() {
        return typeTrain;
    }

    public void setTypeTrain(String typeTrain) {
        this.typeTrain = typeTrain;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public ReservationTrain getReservationTrain() {
        return reservationTrain;
    }

    public void setReservationTrain(ReservationTrain reservationTrain) {
        this.reservationTrain = reservationTrain;
    }

    public Gare getGareDepart() {
        return gareDepart;
    }

    public void setGareDepart(Gare gareDepart) {
        this.gareDepart = gareDepart;
    }

    public Gare getGareArrivee() {
        return gareArrivee;
    }

    public void setGareArrivee(Gare gareArrivee) {
        this.gareArrivee = gareArrivee;
    }

    public CompagnieFerroviaire getCompagnieFerroviaire() {
        return compagnieFerroviaire;
    }

    public void setCompagnieFerroviaire(CompagnieFerroviaire compagnieFerroviaire) {
        this.compagnieFerroviaire = compagnieFerroviaire;
    }

    @Override
    public String toString() {
        return "Trajet{" + "id=" + id + ", numero=" + numero + ", dateHeureDepart=" + dateHeureDepart + ", dateHeureArrivee=" + dateHeureArrivee + ", classeVoyage=" + classeVoyage + ", typeTrain=" + typeTrain + ", nbPlaces=" + nbPlaces + ", reservationTrain=" + reservationTrain + ", gareDepart=" + gareDepart + ", gareArrivee=" + gareArrivee + ", compagnieFerroviaire=" + compagnieFerroviaire + '}';
    }

}
