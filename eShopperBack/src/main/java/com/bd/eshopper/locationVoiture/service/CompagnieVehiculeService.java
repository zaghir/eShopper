package com.bd.eshopper.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.locationVoiture.entity.CompagnieVehicule;
import com.bd.eshopper.locationVoiture.metier.CompagnieVehiculeMetier;

@RestController
public class CompagnieVehiculeService {
	
	@Autowired
	private CompagnieVehiculeMetier compagnieMetier ;
	
	@RequestMapping(value="/api/service/compagnieVehicule" , method=RequestMethod.GET )
	@ResponseBody
	public List<CompagnieVehicule> getAll(){
				
		return compagnieMetier.getAll();
	}
	
	@RequestMapping(value="/api/service/compagnieVehicule" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieVehicule save(@RequestBody CompagnieVehicule o){
		return compagnieMetier.save(o);
	}
	
	@RequestMapping(value="/api/service/compagnieVehicule" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieVehicule update(@RequestBody CompagnieVehicule o){
		return compagnieMetier.upadete(o);		
	}

	@RequestMapping(value="/api/service/compagnieVehicule" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public Long delete(@RequestParam Long id){
		return compagnieMetier.delete(id);
	}
	
	@RequestMapping(value="/api/service/compagnieVehicule/{id}" , method=RequestMethod.GET )
	public CompagnieVehicule findOne(@PathVariable Long id){
		return compagnieMetier.findOne(id);
	}
}
