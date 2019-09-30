package com.bd.eshopper.avion.metier;

import com.bd.eshopper.avion.entity.CompagnieAerienne;
import java.util.List;


public interface CompagnieAerienneMetier {
	
	public CompagnieAerienne findOne(Long id) ;
	public List<CompagnieAerienne> getAll();
	public CompagnieAerienne save(CompagnieAerienne o) ;
	public CompagnieAerienne update(CompagnieAerienne o) ;
	public String delete(Long id) ;
	

}
