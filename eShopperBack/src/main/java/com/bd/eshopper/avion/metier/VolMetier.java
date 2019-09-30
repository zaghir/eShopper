package com.bd.eshopper.avion.metier;

import com.bd.eshopper.avion.entity.Vol;
import java.util.List;


public interface VolMetier {
	
	public Vol findOne(Long id) ;
	public List<Vol> getAll();
	public Vol save(Vol o) ;
	public Vol update(Vol o) ;
	public String delete(Long id) ;
	

}
