package com.bd.eshopper.avion.metier;

import java.util.List;

import com.bd.eshopper.avion.entity.Aeroport;

public interface AeroportMetier {
	
	public Aeroport save(Aeroport o) ;
	public List<Aeroport> getAll();
	public Long delete(Long id) ;
	public Aeroport update(Aeroport o ) ;
	public Aeroport findOne(Long id);

}
