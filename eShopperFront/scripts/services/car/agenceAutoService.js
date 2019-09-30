/**
 * Created by yzaghir on 24/06/2016.
 */
angular.module("eShopperApp")
    .factory("agenceAutoService" ,['$resource' , '$q','$http' ,"CConfigCar" ,
        function($resource , $q ,$http , CConfigCar){

            var service ={
                urlRest : CConfigCar.agenceAuto.url ,
                donnees: [],
                apiRest: apiRest,
                add: add ,
                update:update,
                remove: remove
            };
            return service ;

            function apiRest(){
                var def = $q.defer();
                var result = [];

                var resultRest = $resource(service.urlRest)
                    .query().$promise.then(function(data){
                        data.forEach(function(element){
                            console.log(element);
                            result.push({
                                id: element.id,
                                nom: element.nom,
                                adresse : element.adresse,
                                ville : element.ville,
                                pays : element.pays,
                                latitudeLocation: element.latitudeLocation ,
                                longitudeLocation : element.longitudeLocation ,
                                compagnie : {
                                    id : element.compagnieId ,
                                    nom:element.compagnieNom
                                },
                                activedCss:"" ,
                                actived:true })  ;
                        });
                        def.resolve(result);
                    } ).catch(function(ex){
                        result ="error";
                        def.reject("Failed to get data");
                    }); // pour recuperer des tableau  //console.log(acrissCarCode1Service.apiRest().get());  // pour recuperer des object
                return def.promise ;
            }

            function add(element){
                //element.latitudeLocation = parseFloat(element.latitudeLocation) ;
                //element.longitudeLocation = parseFloat(element.longitudeLocation) ;
                console.log(element);
                var def = $q.defer();
                $http({
                    method:"POST",
                    url :service.urlRest,
                    headers :{"Content-type" : "application/json"} ,
                    data:element
                })
                    .success(function(data) {
                        def.resolve(data);
                    })
                    .error(function(data) {
                        def.reject("Failed to get data");
                    });
                return def.promise;
            }
            function update(element){
                var def = $q.defer();
                $http({
                    method:"PUT",
                    url :service.urlRest,
                    headers :{"Content-type" : "application/json"} ,
                    data:element
                })
                    .success(function(data) {
                        def.resolve(data);
                    })
                    .error(function(data) {
                        def.reject("Failed to get data");
                    });
                return def.promise;
            }
            function remove(element){
                var def = $q.defer();
                //console.log('http://localhost:8080/eShopperBack/api/vehicule/acrissCarCode1?code='+element.code);
                $http({
                    method:"DELETE",
                    url :service.urlRest,
                    data:"id="+element.id,
                    params:{id :element.id},
                    headers :{"Content-type" : "application/x-www-form-urlencoded"}
                })
                    .success(function(data) {
                        console.log("ok");
                        def.resolve("delete ok! ");
                    })
                    .error(function(data) {
                        def.reject("Failed to delete ");
                    });
                return def.promise;

            }

        }]) ;
