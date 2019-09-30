/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("reservationVehiculeController" , ["$state", "$location" , "paiementService", "reservationVehiculeService" , "$timeout" , function($state , $location ,  paiementService, reservationVehiculeService , $timeout){

  var ctrl = this ;
  ctrl.vehicule ={};
  ctrl.error = {};
  
  ctrl.vehicule = $location.search() ;
  console.log($location.search()) ;

  ctrl.validerReservation = function(vehicule , client ){
	  var reservation = null ;
    reservationVehiculeService.add(vehicule , client).then(function(data){
      console.log('add reservation-----------------------');
      console.log(data) ;
      console.log('--------------------------------------');
	  
	 
	  
      if(data.client.email != "error"){
		  $location.path("/payments").search({                              
          reservation: data          
        });
	  }else{
		 ctrl.error.email = "Error dans le mail" ;
		  $timeout(function () {
             ctrl.error.email = "" ;
             ctrl.afficheLeCritere("resultatRecherche") ;
           
          }, 2000);
	  }
      //paiementService.pay.
      
      

    });
    

  }
  /*var paraSearch = $location.search() ;

  vehiculeService.rechercheVehicule(paraSearch).then(function(data){
    console.log(data);
    ctrl.vehicule.listVehicule = data ;

  });
  */
}]);
