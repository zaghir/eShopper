/**
 * Created by yzaghir on 06/07/2016.
 */
angular.module("eShopperApp").controller("rechercheResultatController" , ["$state" ,"$timeout" , "vehiculeService" ,"paginationService" , "$location",
    function($state , $timeout, vehiculeService  , paginationService , $location){

        var ctrl = this ;
        ctrl.vehicule ={};

        console.log($location.search()) ;

        var paraSearch = $location.search() ;

        vehiculeService.rechercheVehicule(paraSearch).then(function(data){
            console.log(data);
            ctrl.vehicule.listVehicule = data ;

        });


    }]);