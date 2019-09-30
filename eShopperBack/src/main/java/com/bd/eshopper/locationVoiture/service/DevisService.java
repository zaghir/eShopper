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

import com.bd.eshopper.locationVoiture.entity.Devis;
import com.bd.eshopper.locationVoiture.metier.DevisMetier;

@RestController
public class DevisService {

	@Autowired
	private DevisMetier devisMetier ;
	
	@RequestMapping(value="/api/vehicule/devis" , method=RequestMethod.GET)
	@ResponseBody
	//@Secured(value = { "ROLE_ADMIN" })
	public List<Devis>getAll(){
		return devisMetier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/devis" , method=RequestMethod.POST)  // {"code": "E", "categorie": "Economy"	}
	//@Secured(value = { "ROLE_ADMIN" } )
	public Object save(@RequestBody @Valid Devis o , BindingResult bindingResult ){		
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return devisMetier.save(o) ;
	}
	
	@RequestMapping(value="/api/vehicule/devis" , method=RequestMethod.PUT)
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid Devis o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return devisMetier.update(o);
	}
	
	@RequestMapping(value="/api/vehicule/devis" , method=RequestMethod.DELETE)
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete( @RequestParam Long id ){
		devisMetier.delete(id);
		//return code;
	}
	
	@RequestMapping(value="/api/vehicule/devis/{code}" , method = RequestMethod.GET)
	public Devis findOne(@PathVariable Long id){		
		return devisMetier.findOne(id);
	}
}
