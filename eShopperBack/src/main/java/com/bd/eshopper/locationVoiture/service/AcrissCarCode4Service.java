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

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode4;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode4Metier;

@RestController
public class AcrissCarCode4Service {

	@Autowired
	private AcrissCarCode4Metier acrissCarCode4Metier ;
	
	@RequestMapping(value="/api/vehicule/acrissCarCode4" , method=RequestMethod.GET)
	@ResponseBody
	public List<AcrissCarCode4> getAll(){
		return acrissCarCode4Metier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode4" , method=RequestMethod.POST)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid AcrissCarCode4 o , BindingResult bindingResult ){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode4Metier.save(o) ;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode4" , method=RequestMethod.PUT)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid AcrissCarCode4 o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode4Metier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode4" , method=RequestMethod.DELETE)
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete( @RequestParam String code ){
		acrissCarCode4Metier.delete(code);
		//return code;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode4/{code}" , method = RequestMethod.GET)
	public AcrissCarCode4 findOne(@PathVariable String code){
		return acrissCarCode4Metier.findOne(code);
	}
}
