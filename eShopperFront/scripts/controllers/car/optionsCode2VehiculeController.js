/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("optionsCode2VehiculeController" , ["$state" ,"$timeout" , "acrissCarCode2Service" ,"paginationService","CConfigCar" ,
    function($state , $timeout, acrissCarCode2Service  , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.code2 = {};
        ctrl.code2.editingData = {};
        ctrl.code2.data = [];
        ctrl.code2.pageCourante = 1 ;

        ctrl.code2.goToPage=function(numeroPage){
            ctrl.code2.pageCourante = numeroPage ;
            ctrl.code2.data = paginationService.getOnePage(ctrl.code2.data , ctrl.code2.pageCourante);

        };

        ctrl.code2.modify = function(el) {
            ctrl.code2.editingData[el.element.code] = true;
        };

        ctrl.code2.viewAll = function(){
            acrissCarCode2Service.apiRest().then(function(data){
                console.log(data);
                ctrl.code2.data = paginationService.getPagination(data , CConfigCar.acrissCarCode2.getAll.ligneParPage) ;
            });
        };


        ctrl.code2.add = function () {
            ctrl.code2.element.id = null;
            acrissCarCode2Service.add(ctrl.code2.element).then(function(data){
                if(!data.errors){
                    ctrl.code2.element = data ;
                    ctrl.code2.errors = null ;

                    ctrl.code2.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.code2.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.code2.element = null ;
                    ctrl.code2.errors = data ;
                }
                ctrl.code2.viewAll();
            });
            ctrl.code2.element ={};
        };


        ctrl.code2.update = function(el){
            acrissCarCode2Service.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.code2.element = data ;
                    //ctrl.code2.errors = null ;
                    ctrl.code2.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.code2.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.code2.viewAll();
            })
            ctrl.code2.editingData[el.element.code]  = false;
            ctrl.code2.element ={};
        };

        ctrl.code2.remove = function(el){
            acrissCarCode2Service.remove(el.element).then(function(data) {
                ctrl.code2.messageInfo =  data;
                $timeout(function () {
                    console.log("---timeout---"+ctrl.code2.messageInfo );
                    ctrl.code2.messageInfo = false;
                }, 2000);

                ctrl.code2.viewAll();
            });
            ctrl.code2.element ={};


        };



    }]);
