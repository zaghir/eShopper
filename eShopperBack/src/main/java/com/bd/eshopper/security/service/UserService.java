package com.bd.eshopper.security.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.security.dao.RoleRepository;
import com.bd.eshopper.security.dao.UserRepository;
import com.bd.eshopper.security.entity.Role;
import com.bd.eshopper.security.entity.User;

@RestController
//@Secured(value={"ROLE_ADMIN"}) 
public class UserService {
	
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private RoleRepository roleRepository ;
	
	@RequestMapping(value="/api/security/user" , method=RequestMethod.POST)
	public User save(User u){
		return userRepository.save(u);		
	}
	@RequestMapping(value="/api/security/user" , method=RequestMethod.PUT)
	public User update(User u){
		return userRepository.save(u);
	}
	@RequestMapping(value="/api/security/user" , method=RequestMethod.DELETE)
	public String delete(String s){
		userRepository.delete(s);
		return s;
	}
	@RequestMapping(value="/api/security/user" , method=RequestMethod.GET)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/api/security/role", method=RequestMethod.POST)
	public Role save(Role r){
		return roleRepository.save(r);
	}
	
	@RequestMapping(value="/api/security/role", method=RequestMethod.GET)
	public List<Role> findRole(){
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/api/security/addRoleToUser")
	public User addRoleToUser(String username , String role){
		User u = userRepository.findOne(username);
		Role r = roleRepository.findOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u ;
	}
	@RequestMapping(value="/getLogedUser")
	public Map<String , Object> getLogedUser(HttpServletRequest httpServletRequest){
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority ga :securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority());
		}
		Map <String, Object> params = new HashMap<>();
		params.put("username",username);
		params.put("roles", roles);
		return params ;
	}

}
