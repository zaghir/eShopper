/**
 * Created by yzaghir on 12/07/2016.
 */
angular.module("eShopperApp").controller("reportReservationVehiculeController" ,
  ["$state", "$timeout" ,"$location","reportReservationVehiculeService" ,"CConfigCar" ,
    function($state , $timeout , $location  , reportReservationVehiculeService, CConfigCar){

      var ctrl = this ;

      ctrl.codeReservation = null ;

      var recherche =$location.search() ;
      reportReservationVehiculeService.getReservation( recherche);
      
      ctrl.generateReport = function(){
        reportReservationVehiculeService.getReservation( ctrl.codeReservation);
      }

      console.log($location.search()) ;

    }]);
