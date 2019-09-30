package com.bd.eshopper.locationVoiture.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.locationVoiture.entity.AgenceAuto;
import com.bd.eshopper.locationVoiture.metier.AgenceAutoMetier;

@RestController
public class AgenceAutoService {
	
	@Autowired
	private AgenceAutoMetier agenceMetier ;
	
	@RequestMapping(value="/api/vehicule/agenceAuto" , method=RequestMethod.GET)
	@ResponseBody
	public List<Object> getAll(){ //List<AgenceAuto>
		List<AgenceAuto> ags =  agenceMetier.getAll() ;	
		List<Object> list =new ArrayList<>();
		for(AgenceAuto a : ags){
			Map<String , Object> element =new HashMap<>() ;
			element.put("id", a.getId());
			element.put("nom", a.getNom());
			element.put("adresse", a.getAdresse());
			element.put("ville", a.getVille());
			element.put("pays", a.getPays());
			element.put("latitudeLocation", a.getLatitudeLocation());
			element.put("longitudeLocation", a.getLongitudeLocation());
			element.put("compagnieId", a.getCompagnie().getId());
			element.put("compagnieNom" , a.getCompagnie().getNom());
			list.add(element);
			
		}
		return list;
	}
	
	@RequestMapping(value="/api/vehicule/agenceAuto" , method=RequestMethod.POST)
	@ResponseBody
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid AgenceAuto o , BindingResult bindingResult){		
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return agenceMetier.save(o);
	}
	
	@RequestMapping(value="/api/vehicule/agenceAuto" , method=RequestMethod.PUT)
	@ResponseBody
	//@Secured(value = { "ROLE_ADMIN" })
	public AgenceAuto update(@RequestBody AgenceAuto o){
		System.out.println( "add --> "+o.getNom()+"  " +o.getAdresse()+"  " +o.getPays()+"  " +o.getVille());
		return agenceMetier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/agenceAuto" , method=RequestMethod.DELETE)	
	//@Secured(value = { "ROLE_ADMIN" })
	public void detele(@RequestParam Long id){
		 agenceMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/agenceAuto/{id}" , method=RequestMethod.GET)
	public AgenceAuto save(@PathVariable Long id){
		return agenceMetier.findOne(id);
	}

}
