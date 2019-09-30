/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("vehiculeController" ,
    ["$state", "$timeout" , "agenceAutoService" , "vehiculeService", "acrissCarCode1Service"
        , "acrissCarCode2Service", "acrissCarCode3Service" , "acrissCarCode4Service","tarifsVehiculeService",
        "devisService" ,"paginationService","CConfigCar" ,
        function($state , $timeout  , agenceAutoService , vehiculeService , acrissCarCode1Service ,
                 acrissCarCode2Service, acrissCarCode3Service , acrissCarCode4Service, tarifsVehiculeService,
                 devisService , paginationService , CConfigCar){

            var ctrl = this ;

            ctrl.vehicule = {};
            ctrl.vehicule.editingData = {};
            ctrl.vehicule.data = [];
            ctrl.vehicule.pageCourante = 1 ;
            ctrl.vehicule.element= {};
            ctrl.vehicule.listPrixVehicule = [{
                prix : null ,
                tarifsVehicule : null,
                vehicule : null
            }
        
            
            
            ];

            ctrl.vehicule.goToPage=function(numeroPage){
                ctrl.vehicule.pageCourante = numeroPage ;
                ctrl.vehicule.data = paginationService.getOnePage(ctrl.vehicule.data , ctrl.vehicule.pageCourante);
            };

            ctrl.vehicule.modify = function(el) {
                console.log(el.element.id);
                ctrl.vehicule.editingData[el.element.id] = true;
            };

            ctrl.vehicule.viewAll = function(){
                vehiculeService.apiRest().then(function(data){
                    console.log(data);
                    ctrl.vehicule.data = paginationService.getPagination(data  , CConfigCar.vehicule.getAll.ligneParPage) ;
                });
            };

            ctrl.vehicule.ajouterUnPrix = function () {
                console.log("Ajouter");
                ctrl.vehicule.listPrixVehicule.push({
                    prix : null ,
                    tarifsVehicule : null,
                    vehicule : null
                });
            }
            ctrl.vehicule.suprimerUnPrix = function () {
                ctrl.vehicule.listPrixVehicule.pop();
            }

            ctrl.vehicule.add = function () {
                ctrl.vehicule.element.id = null;
                ctrl.vehicule.element.prixVehicule = ctrl.vehicule.listPrixVehicule ;
                vehiculeService.add(ctrl.vehicule.element).then(function(data){
                    if(!data.errors){
                        console.log(ctrl.vehicule.element) ;
                        ctrl.vehicule.element = data ;
                        ctrl.vehicule.errors = null ;

                        ctrl.vehicule.messageInfo =  "Add Ok!";
                        $timeout(function () {
                            ctrl.vehicule.messageInfo = false;
                        }, 2000);
                    }else{
                        //ctrl.vehicule.element = null ;
                        ctrl.vehicule.errors = data ;
                    }
                    ctrl.vehicule.viewAll();
                    //ctrl.vehicule.element ={};
                });
            };

            ctrl.vehicule.update = function(el){
                vehiculeService.update(el.element).then(function(data){
                    if(!data.errors){
                        //ctrl.vehicule.element = data ;
                        //ctrl.vehicule.errors = null ;
                        ctrl.vehicule.messageInfo =  "Update Ok!";
                        $timeout(function () {
                            ctrl.vehicule.messageInfo = false;
                        }, 2000);
                    }else{
                        el.errors = data ;
                    }
                    ctrl.vehicule.viewAll();
                    ctrl.vehicule.element ={};
                })
                ctrl.vehicule.editingData[el.element.id]  = false;
                ctrl.vehicule.element.id = null;
                //ctrl.vehicule.element ={};
            };

            ctrl.vehicule.remove = function(el){
                vehiculeService.remove(el.element).then(function(data) {
                    ctrl.vehicule.messageInfo =  data;
                    $timeout(function () {
                        console.log("---timeout---"+ctrl.vehicule.messageInfo );
                        ctrl.vehicule.messageInfo = false;
                    }, 2000);
                    //ctrl.vehicule.element ={};
                    ctrl.vehicule.viewAll();
                });
                //ctrl.code2.element ={};

            };

            ctrl.vehicule.init =function(){
                acrissCarCode1Service.apiRest().then(function(data){
                    ctrl.vehicule.acrissCarCode1 = data ;
                });
                acrissCarCode2Service.apiRest().then(function(data){
                    ctrl.vehicule.acrissCarCode2 = data ;
                });
                acrissCarCode3Service.apiRest().then(function(data){
                    ctrl.vehicule.acrissCarCode3 = data ;
                });
                acrissCarCode4Service.apiRest().then(function(data){
                    ctrl.vehicule.acrissCarCode4 = data ;
                });
                agenceAutoService.apiRest().then(function(data){
                   ctrl.vehicule.agences = data ;
                });
                tarifsVehiculeService.apiRest().then(function(data){
                    ctrl.vehicule.tarifs = data ;
                });
                devisService.apiRest().then(function(data){
                    ctrl.vehicule.devis = data ;
                });
                console.log("init") ;
            }

            ctrl.vehicule.init();

        }]);
