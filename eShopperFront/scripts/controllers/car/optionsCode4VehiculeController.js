/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("optionsCode4VehiculeController" , ["$state" ,"$timeout" , "acrissCarCode4Service" ,"paginationService", "CConfigCar" ,
    function($state , $timeout, acrissCarCode4Service  , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.code4 = {};
        ctrl.code4.editingData = {};
        ctrl.code4.data = [];
        ctrl.code4.pageCourante = 1 ;

        ctrl.code4.goToPage=function(numeroPage){
            ctrl.code4.pageCourante = numeroPage ;
            ctrl.code4.data = paginationService.getOnePage(ctrl.code4.data , ctrl.code4.pageCourante);

        };

        ctrl.code4.modify = function(el) {
            ctrl.code4.editingData[el.element.code] = true;
        };

        ctrl.code4.viewAll = function(){
            acrissCarCode4Service.apiRest().then(function(data){
                ctrl.code4.data = paginationService.getPagination(data , CConfigCar.acrissCarCode4.getAll.ligneParPage) ;
            });
        };


        ctrl.code4.add = function () {
            ctrl.code4.element.id = null;
            acrissCarCode4Service.add(ctrl.code4.element).then(function(data){
                if(!data.errors){
                    ctrl.code4.element = data ;
                    ctrl.code4.errors = null ;

                    ctrl.code4.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.code4.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.code4.element = null ;
                    ctrl.code4.errors = data ;
                }
                ctrl.code4.viewAll();
                ctrl.code4.element ={};
            });

        };


        ctrl.code4.update = function(el){
            acrissCarCode4Service.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.code4.element = data ;
                    //ctrl.code4.errors = null ;
                    ctrl.code4.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.code4.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.code4.viewAll();
            })
            ctrl.code4.editingData[el.element.code]  = false;
            ctrl.code4.element ={};
        };

        ctrl.code4.remove = function(el){
            acrissCarCode4Service.remove(el.element).then(function(data) {
                ctrl.code4.messageInfo =  data;
                $timeout(function () {
                    ctrl.code4.messageInfo = false;
                }, 2000);

                ctrl.code4.viewAll();
            });
            ctrl.code4.element ={};


        };



    }]);
