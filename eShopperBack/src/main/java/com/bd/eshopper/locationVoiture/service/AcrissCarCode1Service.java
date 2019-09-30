package com.bd.eshopper.locationVoiture.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.locationVoiture.entity.AcrissCarCode1;
import com.bd.eshopper.locationVoiture.metier.AcrissCarCode1Metier;

@RestController
public class AcrissCarCode1Service {

	@Autowired
	private AcrissCarCode1Metier acrissCarCode1Metier ;
	
	@RequestMapping(value="/api/vehicule/acrissCarCode1" , method=RequestMethod.GET)
	@ResponseBody
	//@Secured(value = { "ROLE_ADMIN" })
	public List<AcrissCarCode1>getAll(){
		return acrissCarCode1Metier.getAll();
	} 
	
	@RequestMapping(value="/api/vehicule/acrissCarCode1" , method=RequestMethod.POST)  // {"code": "E", "categorie": "Economy"	}
	//@Secured(value = { "ROLE_ADMIN" } )
	public Object save(@RequestBody @Valid AcrissCarCode1 o , BindingResult bindingResult ){
		System.out.println("Methode ==> POST( "+o.getCode()+" "+o.getCategorie()+" )");
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode1Metier.save(o) ;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode1" , method=RequestMethod.PUT)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid AcrissCarCode1 o , BindingResult bindingResult){
		System.out.println("Methode ==> PUT( "+o.getCode()+" "+o.getCategorie()+" )");
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return acrissCarCode1Metier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode1" , method=RequestMethod.DELETE)
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete( @RequestParam String code ){
		//System.out.println("-----------------------delete-----code:"+code);
		AcrissCarCode1 c = new AcrissCarCode1();
		acrissCarCode1Metier.delete(code);
		
		c.setCode(code);
		//return code;
	}
	
	@RequestMapping(value="/api/vehicule/acrissCarCode1/{code}" , method = RequestMethod.GET)
	public AcrissCarCode1 findOne(@PathVariable String code){
		System.out.println("-----------------------getOne-----");
		return acrissCarCode1Metier.findOne(code);
	}
}
