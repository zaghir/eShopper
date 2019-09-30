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

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode2;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode2Metier;

@RestController
public class AcrissCarCode2Service {

	@Autowired
	private AcrissCarCode2Metier acrissCarCode2Metier ;
	
	 
	@RequestMapping(value="/api/vehicule/acrissCarCode2" , method=RequestMethod.GET)
	@ResponseBody
	public List<AcrissCarCode2>getAll(){
		return acrissCarCode2Metier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode2" , method=RequestMethod.POST)    // {"code": "Ccc","typeVehicule": "----"}
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid AcrissCarCode2 o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode2Metier.save(o) ;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode2" , method=RequestMethod.PUT)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid AcrissCarCode2 o ,BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode2Metier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode2" , method=RequestMethod.DELETE)
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete( @RequestParam String code ){
		acrissCarCode2Metier.delete(code);
		//return code;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode2/{code}" , method = RequestMethod.GET)
	public AcrissCarCode2 findOne(@PathVariable String code){
		return acrissCarCode2Metier.findOne(code);
	}
}
