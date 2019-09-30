package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.Devis;

public interface DevisMetier {
	
	public Devis save(Devis o) ;
	public List<Devis> getAll();
	public Devis update(Devis o ) ;
	public Long delete(Long id ) ;
	public Devis findOne(Long id) ;

}
