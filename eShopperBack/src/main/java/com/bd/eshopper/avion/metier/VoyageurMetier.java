package com.bd.eshopper.avion.metier;

import com.bd.eshopper.avion.entity.Voyageur;
import java.util.List;


public interface VoyageurMetier {
	
	public Voyageur findOne(Long id) ;
	public List<Voyageur> getAll();
	public Voyageur save(Voyageur o) ;
	public Voyageur update(Voyageur o) ;
	public String delete(Long id) ;
}
