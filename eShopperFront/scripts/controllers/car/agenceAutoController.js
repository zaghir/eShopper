/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("agenceAutoController" , ["$state" ,"$timeout" , "agenceAutoService" , "compagnieVehiculeService","paginationService", "CConfigCar",
    function($state , $timeout, agenceAutoService , compagnieVehiculeService , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.agenceAuto = {};
        ctrl.agenceAuto.editingData = {};
        ctrl.agenceAuto.data = [];
        ctrl.agenceAuto.pageCourante = 1 ;

        ctrl.agenceAuto.goToPage=function(numeroPage){
            ctrl.agenceAuto.pageCourante = numeroPage ;
            ctrl.agenceAuto.data = paginationService.getOnePage(ctrl.agenceAuto.data , ctrl.agenceAuto.pageCourante);
        };

        ctrl.agenceAuto.modify = function(el) {
            ctrl.agenceAuto.editingData[el.element.id] = true;
        };

        ctrl.agenceAuto.viewAll = function(){
            agenceAutoService.apiRest().then(function(data){
                ctrl.agenceAuto.data = paginationService.getPagination(data , CConfigCar.agenceAuto.getAll.ligneParPage) ;
            });
        };

        compagnieVehiculeService.apiRest().then(function(data){
            ctrl.compagnies = data ;
        });


        ctrl.agenceAuto.add = function () {
            ctrl.agenceAuto.element.id = null;
            agenceAutoService.add(ctrl.agenceAuto.element).then(function(data){
                if(!data.errors){
                    ctrl.agenceAuto.element = data ;
                    ctrl.agenceAuto.errors = null ;

                    ctrl.agenceAuto.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.agenceAuto.messageInfo = false;
                    }, 2000);
                    ctrl.agenceAuto.element ={};
                }else{
                    ctrl.agenceAuto.element = null ;
                    ctrl.agenceAuto.errors = data ;
                }
                ctrl.agenceAuto.viewAll();
            });

        };


        ctrl.agenceAuto.update = function(el){
            agenceAutoService.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.agenceAuto.element = data ;
                    //ctrl.agenceAuto.errors = null ;
                    ctrl.agenceAuto.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.agenceAuto.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.agenceAuto.viewAll();
            })
            ctrl.agenceAuto.editingData[el.element.id]  = false;
            ctrl.agenceAuto.element ={};
        };

        ctrl.agenceAuto.remove = function(el){
            agenceAutoService.remove(el.element).then(function(data) {
                ctrl.agenceAuto.messageInfo =  data;
                $timeout(function () {
                    console.log("---timeout---"+ctrl.agenceAuto.messageInfo );
                    ctrl.agenceAuto.messageInfo = false;
                }, 2000);

                ctrl.agenceAuto.viewAll();
            });
            ctrl.agenceAuto.element ={};
        };

    }]);
