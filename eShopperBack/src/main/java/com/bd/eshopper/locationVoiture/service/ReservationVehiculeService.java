package com.bd.eshopper.locationVoiture.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.bd.eshopper.locationVoiture.entity.ReservationVehicule;
import com.bd.eshopper.locationVoiture.metier.ReservationVehiculeMetier;
import com.bd.eshopper.service.cryptage.ZyCryptage;
import com.bd.eshopper.service.mail.Mailling;

@RestController
public class ReservationVehiculeService {
	
	@Autowired
	private ReservationVehiculeMetier reservationVehiculeMetier ;
	
	@Autowired
	Mailling email;
	
	@Autowired
	private HttpServletRequest contextHttp;
	
	@RequestMapping(value="/api/vehicule/reservationVehicule" , method=RequestMethod.GET )
	@ResponseBody
	public List<ReservationVehicule> getAll(){
		return reservationVehiculeMetier.getAll();
	}
	
	@RequestMapping(value="/api/vehicule/reservationVehicule" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Object save(@RequestBody @Valid ReservationVehicule o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		ReservationVehicule reservation = reservationVehiculeMetier.save(o) ;
		if(reservation != null){
			System.out.println("server name "+contextHttp.getServerName());
			System.out.println("server port "+contextHttp.getServerPort());
			System.out.println("server path "+contextHttp.getServletPath());
			ZyCryptage c = new ZyCryptage();
			String clePrive = c.generatSecretKey() ;
			String textCripte = c.encrypt(o.getCodeReservation(), clePrive);
			System.out.println("clePrive = "+clePrive +"text clair  = "+o.getCodeReservation()+ " textCripte ="+textCripte);
			try {
				email.send(o.getClient().getEmail(),
						"Reservation du Vehicule Ref : "+textCripte ,
						" Votre reservation est terminée Imprimer votre biellet  :  http://"+contextHttp.getServerName()+":"+contextHttp.getServerPort()+"/eShopperBack/#/reportReservationVehicule?v0="+URLEncoder.encode(textCripte, "UTF-8")+"&v1="+URLEncoder.encode(clePrive, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				reservation.getClient().setEmail("error");
				
			}/*finally {
				System.out.println("----------Reservation Prob------------------");
				return reservation;
			}*/
			
		}
		return reservation;
	}
	
	@RequestMapping(value="/api/vehicule/reservationVehicule" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Object update(@RequestBody @Valid ReservationVehicule o , BindingResult bindingResult){
		if(bindingResult.hasErrors() ){
			Map<String , Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()){
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors ;
		}
		return reservationVehiculeMetier.update(o);		
	}

	@RequestMapping(value="/api/vehicule/reservationVehicule" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public void delete(@RequestParam Long id){
		 reservationVehiculeMetier.delete(id);
	}
	
	@RequestMapping(value="/api/vehicule/reservationVehicule/{id}" , method=RequestMethod.GET )
	public ReservationVehicule findOne(@PathVariable Long id){
		return reservationVehiculeMetier.findOne(id);
	}
	
	@RequestMapping(value="/api/vehicule/reservationVehicule/report" , method=RequestMethod.POST )
	public ReservationVehicule getReservation(@RequestParam("v0") String text , @RequestParam("v1") String clePrive){
		System.out.println(text +"     ----    "+ clePrive);
		ZyCryptage c = new ZyCryptage();
		
		return reservationVehiculeMetier.getReservationByCode(c.decrypt(text, clePrive));
	}
	

}
