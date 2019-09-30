/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("compagnieVehiculeController" , ["$state" ,"$timeout" , "compagnieVehiculeService" ,"paginationService","CConfigCar"  ,
    function($state , $timeout, compagnieVehiculeService  , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.compagnie = {};
        ctrl.compagnie.editingData = {};
        ctrl.compagnie.data = [];
        ctrl.compagnie.pageCourante = 1 ;

        ctrl.compagnie.goToPage=function(numeroPage){
            ctrl.compagnie.pageCourante = numeroPage ;
            ctrl.compagnie.data = paginationService.getOnePage(ctrl.compagnie.data , ctrl.compagnie.pageCourante);
        };

        ctrl.compagnie.modify = function(el) {
            ctrl.compagnie.editingData[el.element.id] = true;
        };

        ctrl.compagnie.viewAll = function(){
            compagnieVehiculeService.apiRest().then(function(data){
                ctrl.compagnie.data = paginationService.getPagination(data , CConfigCar.compagnie.getAll.ligneParPage) ;
            });
        };

        ctrl.compagnie.add = function () {
            ctrl.compagnie.element.id = null;
            compagnieVehiculeService.add(ctrl.compagnie.element).then(function(data){
                if(!data.errors){
                    ctrl.compagnie.element = data ;
                    ctrl.compagnie.errors = null ;

                    ctrl.compagnie.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.compagnie.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.compagnie.element = null ;
                    ctrl.compagnie.errors = data ;
                }
                ctrl.compagnie.viewAll();
            });
            ctrl.compagnie.element ={};
        };

        ctrl.compagnie.update = function(el){
            compagnieVehiculeService.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.compagnie.element = data ;
                    //ctrl.compagnie.errors = null ;
                    ctrl.compagnie.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.compagnie.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.compagnie.viewAll();
            })
            ctrl.compagnie.editingData[el.element.id]  = false;
            ctrl.compagnie.element ={};
        };

        ctrl.compagnie.remove = function(el){
            compagnieVehiculeService.remove(el.element).then(function(data) {
                ctrl.compagnie.messageInfo =  data;
                $timeout(function () {
                    console.log("---timeout---"+ctrl.compagnie.messageInfo );
                    ctrl.compagnie.messageInfo = false;
                }, 2000);

                ctrl.compagnie.viewAll();
            });
            ctrl.compagnie.element ={};
        };

    }]);
