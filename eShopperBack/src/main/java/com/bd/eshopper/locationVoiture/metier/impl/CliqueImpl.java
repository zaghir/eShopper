package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.CliqueRepository;
import com.bd.eshopper.locationVoiture.entity.Clique;
import com.bd.eshopper.locationVoiture.metier.CliqueMetier;

@Service
public class CliqueImpl implements CliqueMetier {
	
	@Autowired
	private CliqueRepository cliqueRepository;

	@Override
	public Clique save(Clique o) {
		Clique a = new Clique() ;
		if(cliqueRepository.findOne(o.getId()) == null){
			return cliqueRepository.save(o);
		}else{
			 return a;
		}		
	}

	@Override
	public List<Clique> getAll() {
		return cliqueRepository.findAll();
	}

	@Override
	public Clique update(Clique o) {
		return cliqueRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		if(cliqueRepository.findOne(id) != null){
			cliqueRepository.delete(id);
			return id;	
		}else{
			return 0L ;
		}
	}

	@Override
	public Clique findOne(Long id) {		
		return cliqueRepository.findOne(id);
	}

}
