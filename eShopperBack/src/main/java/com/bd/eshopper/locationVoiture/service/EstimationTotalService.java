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

import com.bd.eshopper.locationVoiture.entity.EstimationTotal;
import com.bd.eshopper.locationVoiture.metier.EstimationTotalMetier;

@RestController
public class EstimationTotalService {
	
	@Autowired
	private EstimationTotalMetier estimationTotalMetier ;
	
	@RequestMapping(value="/api/vehicule/estimationTotal" , method=RequestMethod.GET )
	@ResponseBody
	public List<EstimationTotal> getAll(){
		return estimationTotalMetier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/estimationTotal" , method=RequestMethod.POST )	
	public Object save(@RequestBody @Valid EstimationTotal o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return estimationTotalMetier.save(o);
	}
	
	@RequestMapping(value="/api/vehicule/estimationTotal" , method=RequestMethod.PUT )
	public Object update(@RequestBody @Valid EstimationTotal o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return estimationTotalMetier.update(o);		
	}

	@RequestMapping(value="/api/vehicule/estimationTotal" , method=RequestMethod.DELETE )
	public void delete(@RequestParam Long id){
		 estimationTotalMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/estimationTotal/{id}" , method=RequestMethod.GET )
	public EstimationTotal findOne(@PathVariable Long id){
		return estimationTotalMetier.findOne(id);
	}
	

}
