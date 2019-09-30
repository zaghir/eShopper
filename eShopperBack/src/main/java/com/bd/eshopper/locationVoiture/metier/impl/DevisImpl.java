package com.bd.eshopper.locationVoiture.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.locationVoiture.dao.DevisRepository;
import com.bd.eshopper.locationVoiture.entity.Devis;
import com.bd.eshopper.locationVoiture.metier.DevisMetier;

@Service
public class DevisImpl implements DevisMetier{
	
	@Autowired
	private DevisRepository devisRepository ;

	@Override
	public Devis save(Devis o) {
		Devis a = new Devis() ;
		if(o.getCode() != null ){
			if(devisRepository.findByCode(o.getCode()) == null){
				a = devisRepository.save(o) ;
			}else{
				a.setNom("existe deja");
				a.setCode("existe deja");
			}
		}
		return a ;	
	}

	@Override
	public List<Devis> getAll() {
		return devisRepository.findAll();
	}

	@Override
	public Devis update(Devis o) {
		return devisRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		if(devisRepository.findOne(id) != null)
		devisRepository.delete(id);
		return id;
	}

	@Override
	public Devis findOne(Long id) {
		return devisRepository.findOne(id);
	}
	

}
