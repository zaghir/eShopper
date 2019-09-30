/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("optionsCode3VehiculeController" , ["$state" ,"$timeout" , "acrissCarCode3Service" ,"paginationService","CConfigCar" ,
    function($state , $timeout, acrissCarCode3Service  , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.code3 = {};
        ctrl.code3.editingData = {};
        ctrl.code3.data = [];
        ctrl.code3.pageCourante = 1 ;

        ctrl.code3.goToPage=function(numeroPage){
            ctrl.code3.pageCourante = numeroPage ;
            ctrl.code3.data = paginationService.getOnePage(ctrl.code3.data , ctrl.code3.pageCourante);

        };

        ctrl.code3.modify = function(el) {
            ctrl.code3.editingData[el.element.code] = true;
        };

        ctrl.code3.viewAll = function(){
            acrissCarCode3Service.apiRest().then(function(data){
                ctrl.code3.data = paginationService.getPagination(data , CConfigCar.acrissCarCode3.getAll.ligneParPage) ;
            });
        };


        ctrl.code3.add = function () {
            ctrl.code3.element.id = null;
            acrissCarCode3Service.add(ctrl.code3.element).then(function(data){
                if(!data.errors){
                    ctrl.code3.element = data ;
                    ctrl.code3.errors = null ;

                    ctrl.code3.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.code3.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.code3.element = null ;
                    ctrl.code3.errors = data ;
                }
                ctrl.code3.viewAll();
            });
            ctrl.code3.element ={};
        };


        ctrl.code3.update = function(el){
            acrissCarCode3Service.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.code3.element = data ;
                    //ctrl.code3.errors = null ;
                    ctrl.code3.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.code3.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.code3.viewAll();
            })
            ctrl.code3.editingData[el.element.code]  = false;
            ctrl.code3.element ={};
        };

        ctrl.code3.remove = function(el){
            acrissCarCode3Service.remove(el.element).then(function(data) {
                ctrl.code3.messageInfo =  data;

                $timeout(function () {
                    console.log("---timeout---"+ctrl.code3.messageInfo );
                    ctrl.code3.messageInfo = false;
                }, 2000);

                ctrl.code3.viewAll();
            });
            ctrl.code3.element ={};

        };



    }]);
