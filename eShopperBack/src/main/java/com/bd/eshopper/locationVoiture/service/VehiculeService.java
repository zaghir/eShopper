package com.bd.eshopper.locationVoiture.service;

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

import com.bd.eshopper.locationVoiture.entity.PrixVehicule;
import com.bd.eshopper.locationVoiture.entity.RechercheCritereVehicule;
import com.bd.eshopper.locationVoiture.entity.Vehicule;
import com.bd.eshopper.locationVoiture.metier.PrixVehiculeMetier;
import com.bd.eshopper.locationVoiture.metier.VehiculeMetier;

@RestController
public class VehiculeService {
	
	@Autowired
	private VehiculeMetier vehiculeMetier ;
	
	@Autowired
	private PrixVehiculeMetier prixMetier ;
	
	@RequestMapping(value="/api/vehicule/vehicule" , method=RequestMethod.GET )
	@ResponseBody
	public List<Vehicule> getAll(){
		return vehiculeMetier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/vehicule" , method=RequestMethod.POST )//@Secured(value = { "ROLE_ADMIN" })	
	public Object save(@RequestBody @Valid Vehicule o , BindingResult bindingResult){
		Vehicule v = null ;
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		v = vehiculeMetier.save(o) ;
		if(v != null){
			for(PrixVehicule p : o.getPrixVehicule()){
				p.setVehicule(v);
				prixMetier.save(p);
			}
		}
		return v;
	}
	
	@RequestMapping(value="/api/vehicule/vehicule" , method=RequestMethod.PUT )//@Secured(value = { "ROLE_ADMIN" })	
	public Object update(@RequestBody @Valid Vehicule o , BindingResult bindingResult){
		System.out.println("Put prix : -->"+o.getPrixVehicule().get(0).getMontant());
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return vehiculeMetier.update(o);		
	}

	@RequestMapping(value="/api/vehicule/vehicule" , method=RequestMethod.DELETE )//@Secured(value = { "ROLE_ADMIN" })
	public void delete(@RequestParam Long id){
		System.out.println("------");
		System.out.println("--------delete  id: "+id);		
		vehiculeMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/vehicule/{id}" , method=RequestMethod.GET )
	public Vehicule findOne(@PathVariable Long id){
		return vehiculeMetier.findOne(id);
	}
	@RequestMapping(value="/api/vehicule/vehicule/recherche" , method=RequestMethod.POST )
	public Object recherche(@RequestBody RechercheCritereVehicule recherche){
		Map<String ,Object> m = new HashMap();
		m.put("datePret", recherche.getDatePret()) ;
		m.put("dateRetour", recherche.getDateRetour()) ;
		m.put("heurePret", recherche.getHeurePret()) ;
		m.put("heureRetour", recherche.getHeureRetour()) ;
		m.put("listdata", vehiculeMetier.rechercheVehiculePourLocation(recherche)) ;
			
		return m;
		//return vehiculeMetier.getAll();
	}
	
	

}
