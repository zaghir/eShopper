package com.bd.eshopper.avion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.avion.entity.TerminalAero;
import com.bd.eshopper.avion.metier.TerminalAeroMetier;

@RestController
public class TerminalAeroService {
	
	@Autowired
	private TerminalAeroMetier terminalAeroMetier ;
	
	@RequestMapping(value="/api/avion/terminalAero" , method=RequestMethod.GET )
	@ResponseBody
	public List<TerminalAero> getAll(){
				
		return terminalAeroMetier.getAll();
	}
	
	@RequestMapping(value="/api/avion/terminalAero" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public TerminalAero save(@RequestBody TerminalAero o){
		return terminalAeroMetier.save(o);
	}
	
	@RequestMapping(value="/api/avion/terminalAero" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public TerminalAero update(@RequestBody TerminalAero o){
		return terminalAeroMetier.update(o);		
	}

	@RequestMapping(value="/api/avion/terminalAero" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return terminalAeroMetier.delete(id);
	}
	
	@RequestMapping(value="/api/avion/terminalAero/{id}" , method=RequestMethod.GET )
	public TerminalAero findOne(@PathVariable Long id){
		return terminalAeroMetier.findOne(id);
	}
}
