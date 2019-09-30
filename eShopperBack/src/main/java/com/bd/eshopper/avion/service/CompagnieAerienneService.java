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

import com.bd.eshopper.avion.entity.CompagnieAerienne;
import com.bd.eshopper.avion.metier.CompagnieAerienneMetier;

@RestController
public class CompagnieAerienneService {
	
	@Autowired
	private CompagnieAerienneMetier compagnieAerienneMetier ;
	
	@RequestMapping(value="/api/avion/compagnieAerienne" , method=RequestMethod.GET )
	@ResponseBody
	public List<CompagnieAerienne> getAll(){
				
		return compagnieAerienneMetier.getAll();
	}
	
	@RequestMapping(value="/api/avion/compagnieAerienne" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieAerienne save(@RequestBody CompagnieAerienne o){
		return compagnieAerienneMetier.save(o);
	}
	
	@RequestMapping(value="/api/avion/compagnieAerienne" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieAerienne update(@RequestBody CompagnieAerienne o){
		return compagnieAerienneMetier.update(o);		
	}

	@RequestMapping(value="/api/avion/compagnieAerienne" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return compagnieAerienneMetier.delete(id);
	}
	
	@RequestMapping(value="/api/avion/compagnieAerienne/{id}" , method=RequestMethod.GET )
	public CompagnieAerienne findOne(@PathVariable Long id){
		return compagnieAerienneMetier.findOne(id);
	}
}
