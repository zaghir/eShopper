package com.bd.eshopper.avion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.avion.entity.Aeroport;
import com.bd.eshopper.avion.metier.AeroportMetier;

@RestController
public class AeroportService {
	
	@Autowired
	private AeroportMetier aeroportService ;
	
	@RequestMapping(value="/api/avion/aeroport" , method=RequestMethod.GET)
	@ResponseBody
	public List<Aeroport> getAll(){
		return aeroportService.getAll();
	}
	
	@RequestMapping(value="/api/avion/aeroport" , method=RequestMethod.POST)
	//@Secured(value = { "ROLE_ADMIN" })
	public Aeroport save(@RequestBody Aeroport o){
		return aeroportService.save(o);
	}
        
	
	@RequestMapping(value="/api/avion/aeroport" , method=RequestMethod.PUT)
	//@Secured(value = { "ROLE_ADMIN" })
	public Aeroport update(@RequestBody Aeroport o){
		return aeroportService.update(o);
	}
	@RequestMapping(value="/api/avion/aeroport" , method=RequestMethod.DELETE)
	//@Secured(value = { "ROLE_ADMIN" })
	public Long delete(@RequestParam Long id){
		return aeroportService.delete(id);
	}
	
	@RequestMapping(value="/api/avion/aeroport/{id}" , method=RequestMethod.GET)
	public Aeroport findOne(@PathVariable Long id){
		return aeroportService.findOne(id);
	}

}
