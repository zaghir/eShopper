package com.bd.eshopper.locationVoiture.metier;

import java.util.List;

import com.bd.eshopper.locationVoiture.entity.EstimationTotal;

public interface EstimationTotalMetier {
	
	public EstimationTotal save(EstimationTotal o) ;
	public List<EstimationTotal> getAll();
	public EstimationTotal update(EstimationTotal o) ;
	public Long delete( Long id ) ;
	public EstimationTotal findOne(Long id) ;
	

}
