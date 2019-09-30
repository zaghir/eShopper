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

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode3;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode3Metier;

@RestController
public class AcrissCarCode3Service {

	@Autowired
	private AcrissCarCode3Metier acrissCarCode3Metier ;
	
	@RequestMapping(value="/api/vehicule/acrissCarCode3" , method=RequestMethod.GET)
	@ResponseBody
	public List<AcrissCarCode3>getAll(){
		return acrissCarCode3Metier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode3" , method=RequestMethod.POST)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid AcrissCarCode3 o , BindingResult bindingResult ){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode3Metier.save(o) ;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode3" , method=RequestMethod.PUT)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid AcrissCarCode3 o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode3Metier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode3" , method=RequestMethod.DELETE)
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete( @RequestParam String code ){
		acrissCarCode3Metier.delete(code);
		//return code;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode3/{code}" , method = RequestMethod.GET)
	public AcrissCarCode3 findOne(@PathVariable String code){
		return acrissCarCode3Metier.findOne(code);
	}
}
