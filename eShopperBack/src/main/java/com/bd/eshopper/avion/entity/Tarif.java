/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd.eshopper.avion.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author lbalit
 */
@Entity
public class Tarif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float prixParAdulte;
    private Float TaxeaPrAdulte;
    private Float prixParEnfant;
    private Float TaxeParEnfant;
    private Float prixParBebe;
    private Float TaxeParBebe;
    private String monaie;
    private Boolean remboursement;
    private Boolean echange;
    @OneToMany(mappedBy = "tarif")
    private List<ReservationVol> reservationVols;
    

    public Tarif() {
    }

    public Tarif(Float prixParAdulte, Float TaxeaPrAdulte, Float prixParEnfant, Float TaxeParEnfant, Float prixParBebe, Float TaxeParBebe, String monaie, Boolean remboursement, Boolean echange) {
        this.prixParAdulte = prixParAdulte;
        this.TaxeaPrAdulte = TaxeaPrAdulte;
        this.prixParEnfant = prixParEnfant;
        this.TaxeParEnfant = TaxeParEnfant;
        this.prixParBebe = prixParBebe;
        this.TaxeParBebe = TaxeParBebe;
        this.monaie = monaie;
        this.remboursement = remboursement;
        this.echange = echange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrixParAdulte() {
        return prixParAdulte;
    }

    public void setPrixParAdulte(Float prixParAdulte) {
        this.prixParAdulte = prixParAdulte;
    }

    public Float getTaxeaPrAdulte() {
        return TaxeaPrAdulte;
    }

    public void setTaxeaPrAdulte(Float TaxeaPrAdulte) {
        this.TaxeaPrAdulte = TaxeaPrAdulte;
    }

    public Float getPrixParEnfant() {
        return prixParEnfant;
    }

    public void setPrixParEnfant(Float prixParEnfant) {
        this.prixParEnfant = prixParEnfant;
    }

    public Float getTaxeParEnfant() {
        return TaxeParEnfant;
    }

    public void setTaxeParEnfant(Float TaxeParEnfant) {
        this.TaxeParEnfant = TaxeParEnfant;
    }

    public Float getPrixParBebe() {
        return prixParBebe;
    }

    public void setPrixParBebe(Float prixParBebe) {
        this.prixParBebe = prixParBebe;
    }

    public Float getTaxeParBebe() {
        return TaxeParBebe;
    }

    public void setTaxeParBebe(Float TaxeParBebe) {
        this.TaxeParBebe = TaxeParBebe;
    }

    public String getMonaie() {
        return monaie;
    }

    public void setMonaie(String monaie) {
        this.monaie = monaie;
    }

    public Boolean getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(Boolean remboursement) {
        this.remboursement = remboursement;
    }

    public Boolean getEchange() {
        return echange;
    }

    public void setEchange(Boolean echange) {
        this.echange = echange;
    }

}
