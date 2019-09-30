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

import com.bd.eshopper.avion.entity.Voyageur;
import com.bd.eshopper.avion.metier.VoyageurMetier;

@RestController
public class VoyageurService {
	
	@Autowired
	private VoyageurMetier voyageurMetier ;
	
	@RequestMapping(value="/api/avion/voyageur" , method=RequestMethod.GET )
	@ResponseBody
	public List<Voyageur> getAll(){
				
		return voyageurMetier.getAll();
	}
	
	@RequestMapping(value="/api/avion/voyageur" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Voyageur save(@RequestBody Voyageur o){
		return voyageurMetier.save(o);
	}
	
	@RequestMapping(value="/api/avion/voyageur" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Voyageur update(@RequestBody Voyageur o){
		return voyageurMetier.update(o);		
	}

	@RequestMapping(value="/api/avion/voyageur" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return voyageurMetier.delete(id);
	}
	
	@RequestMapping(value="/api/avion/voyageur/{id}" , method=RequestMethod.GET )
	public Voyageur findOne(@PathVariable Long id){
		return voyageurMetier.findOne(id);
	}
}
