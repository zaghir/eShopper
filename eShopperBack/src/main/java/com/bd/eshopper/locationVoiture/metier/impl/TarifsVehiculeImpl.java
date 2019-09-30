package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.TarifsVehiculeRepository;
import com.bd.eshopper.locationVoiture.entity.TarifsVehicule;
import com.bd.eshopper.locationVoiture.metier.TarifsVehiculeMetier;

@Service
public class TarifsVehiculeImpl implements TarifsVehiculeMetier{
	
	@Autowired
	private TarifsVehiculeRepository tarifsRepository ;

	@Override
	public TarifsVehicule save(TarifsVehicule o) {
		
		TarifsVehicule a = new TarifsVehicule() ;		
		if(o.getId() == null){	
			System.out.println("------"+o.getType());
			if(tarifsRepository.findByTypeVehicule(o.getType()) == null){
				a =  tarifsRepository.save(o);
			}else{
				a.setType("existe deja");
			}			
		}
		return a ;
	}

	@Override
	public List<TarifsVehicule> getAll() {
		return tarifsRepository.findAll();
	}

	@Override
	public TarifsVehicule update(TarifsVehicule o) {
		return tarifsRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		if(tarifsRepository.findOne(id) != null){
			tarifsRepository.delete(id);
			return id ;
		}else{
			return 0L ;
		}
	}

	@Override
	public TarifsVehicule findOne(Long id) {
		return tarifsRepository.findOne(id);
	}
	
	

}
