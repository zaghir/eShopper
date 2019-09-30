package com.bd.eshopper.service.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.service.dao.ClientRepository;
import com.bd.eshopper.service.entity.Client;
import com.bd.eshopper.service.metier.ClientMetier;

@Service
public class ClientImpl implements ClientMetier{
	
	@Autowired
	private ClientRepository clientRepository ;

	@Override
	public Client save(Client o) {
		return clientRepository.save(o);
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client update(Client o) {
		return clientRepository.save(o);
	}

	@Override
	public Long delete(Long id) {
		clientRepository.delete(id);
		return id;
	}

	@Override
	public Client findOne(Long id) {
		return clientRepository.findOne(id);
	}
	

}
