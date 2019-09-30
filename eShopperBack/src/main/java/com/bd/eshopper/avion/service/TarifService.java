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

import com.bd.eshopper.avion.entity.Tarif;
import com.bd.eshopper.avion.metier.TarifMetier;

@RestController
public class TarifService {
	
	@Autowired
	private TarifMetier tarifMetier ;
	
	@RequestMapping(value="/api/avion/tarif" , method=RequestMethod.GET )
	@ResponseBody
	public List<Tarif> getAll(){
				
		return tarifMetier.getAll();
	}
	
	@RequestMapping(value="/api/avion/tarif" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Tarif save(@RequestBody Tarif o){
		return tarifMetier.save(o);
	}
	
	@RequestMapping(value="/api/avion/tarif" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Tarif update(@RequestBody Tarif o){
		return tarifMetier.update(o);		
	}

	@RequestMapping(value="/api/avion/tarif" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return tarifMetier.delete(id);
	}
	
	@RequestMapping(value="/api/avion/tarif/{id}" , method=RequestMethod.GET )
	public Tarif findOne(@PathVariable Long id){
		return tarifMetier.findOne(id);
	}
}
