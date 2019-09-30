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

import com.bd.eshopper.avion.entity.Vol;
import com.bd.eshopper.avion.metier.VolMetier;

@RestController
public class VolService {
	
	@Autowired
	private VolMetier volMetier ;
	
	@RequestMapping(value="/api/avion/vol" , method=RequestMethod.GET )
	@ResponseBody
	public List<Vol> getAll(){
				
		return volMetier.getAll();
	}
	
	@RequestMapping(value="/api/avion/vol" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Vol save(@RequestBody Vol o){
		return volMetier.save(o);
	}
	
	@RequestMapping(value="/api/avion/vol" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Vol update(@RequestBody Vol o){
		return volMetier.update(o);		
	}

	@RequestMapping(value="/api/avion/vol" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return volMetier.delete(id);
	}
	
	@RequestMapping(value="/api/avion/vol/{id}" , method=RequestMethod.GET )
	public Vol findOne(@PathVariable Long id){
		return volMetier.findOne(id);
	}
}
