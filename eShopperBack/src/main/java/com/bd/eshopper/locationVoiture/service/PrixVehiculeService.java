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
import com.bd.eshopper.locationVoiture.metier.PrixVehiculeMetier;

@RestController
public class PrixVehiculeService {

	@Autowired
	private PrixVehiculeMetier prixMetier ;
	
	@RequestMapping(value="/api/vehicule/prixVehicule" , method=RequestMethod.GET )
	@ResponseBody
	public List<PrixVehicule> getAll(){
		return prixMetier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/prixVehicule" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid PrixVehicule o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return prixMetier.save(o);
	}
	
	@RequestMapping(value="/api/vehicule/prixVehicule" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public PrixVehicule update(@RequestBody PrixVehicule o){
		return prixMetier.update(o);		
	}

	@RequestMapping(value="/api/vehicule/prixVehicule" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete(@RequestParam Long id){
		 prixMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/prixVehicule/{id}" , method=RequestMethod.GET )
	public PrixVehicule findOne(@PathVariable Long id){
		return prixMetier.findOne(id);
	}
	
}
