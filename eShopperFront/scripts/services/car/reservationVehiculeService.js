/**
 * Created by yzaghir on 11/07/2016.
 */
angular.module("eShopperApp")
  .factory("reservationVehiculeService" ,['$resource' , '$q','$http' , "CConfigCar", function($resource , $q , $http , CConfigCar){

    var service ={
      urlRest :CConfigCar.reservation.url ,
      donnees: [],
      add: add ,
      update:update,
      remove: remove
    }
    return service ;

    function add( veh ,client){
      var def = $q.defer();

      var obj = {
        datePret : veh.datePret,
        dateRetour : veh.dateRetour,
        heurePret : veh.heurePret,
        heureRetour : veh.heureRetour,
        vehicule : {id : veh.vehicule.id},
        client : client,
        prix : veh.vehicule.totalPrix.prixVehicule.montant,
        typeReservation: "RA"
      }
     console.log(obj);
      $http({
        method:"POST",
        url :service.urlRest,
        headers :{"Content-type" : "application/json"} ,
        data:obj
      })
        .success(function(data) {
          def.resolve(data);
        })
        .error(function(data) {
          def.reject("Failed to get data");
        });
      return def.promise;

    }

    function remove(){

    };

    function update(){

    };



  }]);
