/**
 * Created by yzaghir on 24/06/2016.
 */
angular.module("eShopperApp")
    .factory("rechercheVehiculeService" ,['$resource' , '$q',
        function($resource , $q){

            var service ={
                donnees: [],
                rechercheVehicule:rechercheVehicule,
                apiExt : {
                    apikey:"kAWrZ7vtGYSvoUwe2T9BxkX30OrYGNJL",
                    location:null,
                    pick_up:null ,
                    drop_off:null,
                    lang : null,
                    currency :null,
                    provider:null,
                    rate_class :null,
                    rate_plan :null,
                    rate_filter :null,
                    vehicle :null
                } ,

            };
            return service ;


            function rechercheVehicule(categorie , location, dateDepart , dateRetour ){
                var def = $q.defer();

                service.apiExt.pick_up = dateDepart ;
                 service.apiExt.drop_off = dateRetour ;
                 service.apiExt.location = location ;
                console.log(service.apiExt);
                var resultRest = $resource('https://api.sandbox.amadeus.com/v1.2/cars/search-airport?'+
                    'apikey='+service.apiExt.apikey+
                    '&location='+service.apiExt.location+
                    '&pick_up='+service.apiExt.pick_up+
                    '&drop_off='+service.apiExt.drop_off)
                    .get().$promise.then(function(data){

                        def.resolve(data);
                    } ).catch(function(ex){
                        result ="error";
                        def.reject("Failed to get data");
                    });
                return def.promise ;

            }

        }]) ;
