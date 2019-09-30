package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.AgenceAuto;

public interface AgenceAutoMetier {
	
	public AgenceAuto save(AgenceAuto o);
	public List<AgenceAuto> getAll();
	public Long delete(Long id) ;
	public AgenceAuto update(AgenceAuto o);
	public AgenceAuto findOne(Long id) ;

}
