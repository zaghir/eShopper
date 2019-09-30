/**
 * Created by yzaghir on 24/06/2016.
 */
angular.module("eShopperApp")
    .factory("vehiculeService" ,['$resource' , '$q','$http' , "CConfigCar" ,
        function($resource , $q ,$http , CConfigCar){

            var service ={
                urlRest :CConfigCar.vehicule.url ,
                donnees: [],
                apiRest: apiRest,
                add: add ,
                update:update,
                remove: remove,
                rechercheVehicule : rechercheVehicule,
                test : test
            };
            return service ;

            function apiRest(){
                var def = $q.defer();
                var result = [];

                var resultRest = $resource(service.urlRest)
                    .query().$promise.then(function(data){
                        data.forEach(function(element){
                            result.push({
                                id: element.id,
                                nom : element.nom,
                                numeroSerie : element.numeroSerie,
                                immatriculation : element.immatriculation ,
                                reserver: element.reserver ,
                                acrissCarCode1 : element.acrissCarCode1,
                                acrissCarCode2 : element.acrissCarCode2,
                                acrissCarCode3 : element.acrissCarCode3,
                                acrissCarCode4 : element.acrissCarCode4,
                                agence : element.agence ,
                                prixVehicule : element.prixVehicule,
                                cliques : element.cliques ,
                                images : element.images ,
                                estimationTotals : element.estimationTotals,
                                activedCss:"" ,
                                actived:true })  ;
                        });
                        def.resolve(result);
                    } ).catch(function(ex){
                        result ="error";
                        def.reject("Failed to get data");
                    });
                return def.promise ;
            }

            function add(element){
                var prix =[];
                element.prixVehicule.forEach(function (e) {
                    prix.push({
                        tarifsVehicule : {id : e.tarifsVehicule.id} ,
                        montant : e.montant ,
                        devis: {id:e.devis.id}
                    })
                });
                var veh = {
                    immatriculation : element.immatriculation ,
                    nom : element.nom,
                    numeroSerie : element.numeroSerie,
                    acrissCarCode1 :{
                        code :element.acrissCarCode1.code
                    },
                    acrissCarCode2: {
                        code :element.acrissCarCode2.code
                    },
                    acrissCarCode3: {
                        code :element.acrissCarCode3.code
                    },
                    acrissCarCode4: {
                        code :element.acrissCarCode4.code
                    },
                    reserver : 0 ,
                    agence :{
                        id :element.agence.id
                        //compagnie : element.agence.compagnie.id
                    },
                    prixVehicule : prix

                };

                var def = $q.defer();
                $http({
                    method:"POST",
                    url :service.urlRest,
                    headers :{"Content-type" : "application/json"} ,
                    data:veh
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
                console.log("delete "+element.id)
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

            function test(element){
                console.log(element);
            };

            function rechercheVehicule( recherche){
                var def = $q.defer();
                $http({
                    method:"POST",
                    url :service.urlRest+"/recherche",
                    headers :{"Content-type" : "application/json"} ,
                    data:recherche
                    //params:recherche
                })
                    .success(function(data) {
                        /*var t =new Array();
                        data.listdata.forEach(function(element){
                            t.push({
                                datePret :
                            })

                        });*/

                        def.resolve(data);
                    })
                    .error(function(data) {
                        def.reject("Failed to get data");
                    });
                return def.promise;
            }

        }]) ;
