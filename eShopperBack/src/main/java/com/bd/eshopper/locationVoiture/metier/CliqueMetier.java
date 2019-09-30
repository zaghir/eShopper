package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.Clique;

public interface CliqueMetier {
	
	public Clique save(Clique o) ;
	public List<Clique> getAll();
	public Clique update(Clique o) ;
	public Long delete(Long id ) ;
	public Clique findOne(Long id ) ;

}
