package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.EstimationTotalRepository;
import com.bd.eshopper.locationVoiture.entity.EstimationTotal;
import com.bd.eshopper.locationVoiture.metier.EstimationTotalMetier;

@Service
public class EstimationTotalImpl implements EstimationTotalMetier{
	
	@Autowired
	private EstimationTotalRepository estimationTotalRepository ;

	@Override
	public EstimationTotal save(EstimationTotal o) {
		EstimationTotal a = new EstimationTotal() ;
		if(estimationTotalRepository.findOne(o.getId()) == null){
			return estimationTotalRepository.save(o);
		}else{
			 a.setMontant(-0.0);			 
			 return a;
		}
	}

	@Override
	public List<EstimationTotal> getAll() {
		return estimationTotalRepository.findAll();
	}

	@Override
	public EstimationTotal update(EstimationTotal o) {
		return estimationTotalRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		if(estimationTotalRepository.findOne(id) != null){
			estimationTotalRepository.delete(id);
			return id;
		}else{
			return 0L;
		}
		
	}

	@Override
	public EstimationTotal findOne(Long id) {
		return estimationTotalRepository.findOne(id);
	}
	
	

}
