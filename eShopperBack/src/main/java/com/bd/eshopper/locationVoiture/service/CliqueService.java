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

import com.bd.eshopper.locationVoiture.entity.Clique;
import com.bd.eshopper.locationVoiture.metier.CliqueMetier;

@RestController
public class CliqueService {
	
	@Autowired
	private CliqueMetier cliqueMetier ;

	@RequestMapping(value="/api/clique" , method=RequestMethod.GET)
	@ResponseBody
	public List<Clique> getAll(){
		return cliqueMetier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/clique" , method=RequestMethod.POST)
	public Clique save(@RequestBody Clique o){
		return cliqueMetier.save(o);
	}
	
	@RequestMapping(value="/api/vehicule/clique" , method=RequestMethod.PUT)
	public Clique update(@RequestBody Clique o){
		return cliqueMetier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/clique" , method=RequestMethod.DELETE)
	public void delete(@RequestParam Long id){
		 cliqueMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/clique/{id}" , method=RequestMethod.GET)
	public Clique findOne(@PathVariable Long id){
		return cliqueMetier.findOne(id);
	}
}
