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

import com.bd.eshopper.avion.entity.ReservationVol;
import com.bd.eshopper.avion.entity.Voyageur;
import com.bd.eshopper.avion.metier.ReservationVolMetier;

@RestController
public class ReservationVolService {
	
	@Autowired
	private ReservationVolMetier reservationVolMetier ;
	
	@RequestMapping(value="/api/avion/reservation" , method=RequestMethod.GET )
	@ResponseBody
	public List<ReservationVol> getAll(){
				
		return reservationVolMetier.getAll();
	}
	
	@RequestMapping(value="/api/avion/reservation" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public ReservationVol save(@RequestBody ReservationVol o){
            for( Voyageur v : o.getVoyageurs()){
                System.out.println(" nom---  "+v.getNom());
            } 
		return reservationVolMetier.save(o);
	}
	
	@RequestMapping(value="/api/avion/reservation" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public ReservationVol update(@RequestBody ReservationVol o){
		return reservationVolMetier.update(o);		
	}

	@RequestMapping(value="/api/avion/reservation" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return reservationVolMetier.delete(id);
	}
	
	@RequestMapping(value="/api/avion/reservation/{id}" , method=RequestMethod.GET )
	public ReservationVol findOne(@PathVariable Long id){
		return reservationVolMetier.findOne(id);
	}
}
