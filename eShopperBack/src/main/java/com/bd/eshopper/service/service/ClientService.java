package com.bd.eshopper.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.service.entity.Client;
import com.bd.eshopper.service.metier.ClientMetier;


@RestController
public class ClientService {
	
	@Autowired
	private ClientMetier clientMetier ;
	
	@RequestMapping(value="/api/service/client" , method=RequestMethod.GET)
	@ResponseBody
	public List<Client> getAll(){
		return clientMetier.getAll();
	}
	
	@RequestMapping(value="/api/service/client" , method=RequestMethod.POST)
	public Client save(@RequestBody Client o){
		return clientMetier.save(o);				
	}
	
	@RequestMapping(value="/api/service/client" , method=RequestMethod.PUT)
	public Client update(@RequestBody Client o ){
		return clientMetier.update(o);
	}
	
	@RequestMapping(value="/api/service/client" , method=RequestMethod.DELETE)
	public Long delete(@RequestParam Long id ){
		return clientMetier.delete(id);
	}
	
	@RequestMapping(value="/api/service/client/{id}" , method=RequestMethod.GET)
	public Client findOne(@PathVariable Long id){
		return clientMetier.findOne(id);
	}
	
	/*@RequestMapping(value="/getLogedUser")
	public Map<String , Object> getLogedUser(HttpServletRequest httpServletRequest){
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username= securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority ga :securityContext.getAuthentication().getAuthorities() ){
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles) ;
		return params ;
	}*/

}
