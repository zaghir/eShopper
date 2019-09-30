package com.bd.eshopper.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.bd.eshopper.avion.entity.ReservationVol;
import com.bd.eshopper.hotel.entity.ReservationHotel;
import com.bd.eshopper.locationVoiture.entity.ReservationVehicule;
import com.bd.eshopper.train.entity.ReservationTrain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_VEHICULE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeReservation" ,visible =true)
@JsonSubTypes({
    @Type(name = "RV", value = ReservationVol.class),
    @Type(name = "RA", value = ReservationVehicule.class),
    @Type(name = "RT", value = ReservationTrain.class),
    @Type(name = "RH", value = ReservationHotel.class),})
@XmlSeeAlso({ReservationVol.class, ReservationVehicule.class , ReservationTrain.class ,ReservationHotel.class})
public abstract class Reservation implements Serializable {

    /**
	 * cwxcwx
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeReservation;
    private Date dateCreation;
    private String idPaiement ;

    @OneToOne(mappedBy = "reservation")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Reservation() {
    	this.dateCreation = new Date();
    }

    public Reservation(String codeReservation, Date dateCreation, Double prix) {
        this.codeReservation = codeReservation;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeReservation() {
        return codeReservation;
    }

    public void setCodeReservation(String codeReservation) {
        this.codeReservation = codeReservation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public String getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(String idPaiement) {
		this.idPaiement = idPaiement;
	}

	@Override
    public String toString() {
        return "Reservation [id=" + id + ", codeReservation=" + codeReservation + ", dateCreation=" + dateCreation
                + ", facture=" + facture + "]";
    }
}
