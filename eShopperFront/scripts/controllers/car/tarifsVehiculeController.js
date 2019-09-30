/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("tarifsVehiculeController" , ["$state" ,"$timeout" , "tarifsVehiculeService" ,"paginationService", "CConfigCar" ,
    function($state , $timeout, tarifsVehiculeService  , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.tarif = {};
        ctrl.tarif.editingData = {};
        ctrl.tarif.data = [];
        ctrl.tarif.pageCourante = 1 ;

        ctrl.tarif.goToPage=function(numeroPage){
            ctrl.tarif.pageCourante = numeroPage ;
            ctrl.tarif.data = paginationService.getOnePage(ctrl.tarif.data , ctrl.tarif.pageCourante);

        };

        ctrl.tarif.modify = function(el) {
            ctrl.tarif.editingData[el.element.id] = true;
        };

        ctrl.tarif.viewAll = function(){
            tarifsVehiculeService.apiRest().then(function(data){
                ctrl.tarif.data = paginationService.getPagination(data , CConfigCar.tarifs.getAll.ligneParPage) ;
            });
        };


        ctrl.tarif.add = function () {
            console.log(ctrl.tarif.element) ;
            ctrl.tarif.element.id = null;
            tarifsVehiculeService.add(ctrl.tarif.element).then(function(data){
                if(!data.errors){
                    ctrl.tarif.element = data ;
                    ctrl.tarif.errors = null ;
                    ctrl.tarif.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.tarif.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.tarif.element = null ;
                    ctrl.tarif.errors = data ;
                }
                ctrl.tarif.viewAll();
            });

        };


        ctrl.tarif.update = function(el){
            tarifsVehiculeService.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.tarif.element = data ;
                    //ctrl.tarif.errors = null ;
                    ctrl.tarif.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.tarif.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.tarif.viewAll();
            })
            ctrl.tarif.editingData[el.element.id]  = false;
            ctrl.tarif.element ={};
        };

        ctrl.tarif.remove = function(el){
            tarifsVehiculeService.remove(el.element).then(function(data) {
                ctrl.tarif.messageInfo =  data;
                $timeout(function () {
                    ctrl.tarif.messageInfo = false;
                }, 2000);

                ctrl.tarif.viewAll();
            });
            ctrl.tarif.element ={};
        };

    }]);
