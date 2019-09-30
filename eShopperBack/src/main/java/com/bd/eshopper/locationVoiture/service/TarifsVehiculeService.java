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

import com.bd.eshopper.locationVoiture.entity.TarifsVehicule;
import com.bd.eshopper.locationVoiture.metier.TarifsVehiculeMetier;

@RestController
public class TarifsVehiculeService {

	@Autowired
	private TarifsVehiculeMetier tarifsMetier;
	
	@RequestMapping(value="/api/vehicule/tarifsVehicule" , method=RequestMethod.GET )
	@ResponseBody
	public List<TarifsVehicule> getAll(){
		return  tarifsMetier.getAll() ;	
	}
	
	@RequestMapping(value="/api/vehicule/tarifsVehicule" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid TarifsVehicule o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return tarifsMetier.save(o);

	}
	
	@RequestMapping(value="/api/vehicule/tarifsVehicule" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid TarifsVehicule o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return tarifsMetier.update(o);		
	}

	@RequestMapping(value="/api/vehicule/tarifsVehicule" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete(@RequestParam Long id){
		 tarifsMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/tarifsVehicule/{id}" , method=RequestMethod.GET )
	public TarifsVehicule findOne(@PathVariable Long id){
		return tarifsMetier.findOne(id);
	}
}
