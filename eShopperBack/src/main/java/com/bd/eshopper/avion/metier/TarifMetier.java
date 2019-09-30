package com.bd.eshopper.avion.metier;

import com.bd.eshopper.avion.entity.Tarif;
import java.util.List;


public interface TarifMetier {
	
	public Tarif findOne(Long id) ;
	public List<Tarif> getAll();
	public Tarif save(Tarif o) ;
	public Tarif update(Tarif o) ;
	public String delete(Long id) ;
}
