package com.bd.eshopper.avion.metier.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.avion.dao.AeroportRepository;
import com.bd.eshopper.avion.entity.Aeroport;
import com.bd.eshopper.avion.metier.AeroportMetier;

@Service
public class AeroportImpl implements AeroportMetier{

	@Autowired
	private AeroportRepository aeroportRepository;

	@Override
	public Aeroport save(Aeroport o) {
		Aeroport a = new Aeroport() ;
		if(aeroportRepository.findByCode(o.getCode()) == null){
			return aeroportRepository.save(o);
		}else{
			a.setCode("existe deja");
			 a.setAdresse("existe deja");
			 a.setPays("existe deja");
			 return a;
		}

	}

	@Override
	public List<Aeroport> getAll() {
		return aeroportRepository.findAll();
	}

	@Override
	public Long delete(Long id) {
		if(aeroportRepository.findOne(id) != null){
			aeroportRepository.delete(id);
			return id;
		}else{
			return 0L ;
		}
		
	}

	@Override
	public Aeroport update(Aeroport o) {
		return aeroportRepository.save(o);
	}

	@Override
	public Aeroport findOne(Long id) {
		return aeroportRepository.findOne(id);
	}
	
}
