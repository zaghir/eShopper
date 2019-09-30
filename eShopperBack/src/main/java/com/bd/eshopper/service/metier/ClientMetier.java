package com.bd.eshopper.service.metier;

import java.util.List;

import com.bd.eshopper.service.entity.Client;

public interface ClientMetier {
	
	public Client save(Client o) ;
	public List<Client> getAll();
	public Client update(Client o) ;
	public Long delete(Long id) ;
	public Client findOne(Long id) ;
	

}
