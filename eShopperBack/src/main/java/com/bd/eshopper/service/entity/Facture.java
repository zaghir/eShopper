package com.bd.eshopper.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private Date dateFacturation;

    @OneToOne
    @JoinColumn(name = "facture_id")
    private Reservation reservation;

    public Facture() {
        
    }

    public Facture(int numero, Date dateFacturation, Reservation reservation) {
        this.numero = numero;
        this.dateFacturation = dateFacturation;
        this.reservation = reservation;
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

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", numero=" + numero + ", dateFacturation=" + dateFacturation + ", reservation=" + reservation + '}';
    }
    
    

}
