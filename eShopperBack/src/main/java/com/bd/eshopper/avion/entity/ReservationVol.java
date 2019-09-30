package com.bd.eshopper.avion.entity;

import com.bd.eshopper.assurance.entity.Assurance;
import com.bd.eshopper.service.entity.Client;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import com.bd.eshopper.service.entity.Reservation;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class ReservationVol extends Reservation {

    @ManyToMany
    @JoinTable(name = "reservationvol_vol")
    private List<Vol> vols;

    @ManyToOne()
    @JoinColumn(name = "tarif_id")
    private Tarif tarif;

    @ManyToMany
    @JoinTable(name = "reservationvol_voyageur")
    private List<Voyageur> voyageurs;

    @ManyToOne
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    public ReservationVol() {
    }
    
    public List<Vol> getVols() {
        return vols;
    }

    public void setVols(List<Vol> vols) {
        this.vols = vols;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }


    public List<Voyageur> getVoyageurs() {
        return voyageurs;
    }

    public void setVoyageurs(List<Voyageur> voyageurs) {
        this.voyageurs = voyageurs;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }
    
    
    
}
