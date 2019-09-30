/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("optionsCode1VehiculeController" , ["$state" ,"$timeout" , "acrissCarCode1Service" ,"paginationService","CConfigCar" ,
    function($state , $timeout, acrissCarCode1Service  , paginationService , CConfigCar){


        var ctrl = this ;

        ctrl.code1 = {};
        ctrl.code1.editingData = {};
        ctrl.code1.data = [];
        ctrl.code1.pageCourante = 1 ;

        ctrl.code1.goToPage=function(numeroPage){
            ctrl.code1.pageCourante = numeroPage ;
            ctrl.code1.data = paginationService.getOnePage(ctrl.code1.data , ctrl.code1.pageCourante);

        };

        ctrl.code1.modify = function(el) {
            ctrl.code1.editingData[el.element.code] = true;
        };

        ctrl.code1.viewAll = function(){
            acrissCarCode1Service.apiRest().then(function(data){
                ctrl.code1.data = paginationService.getPagination(data , CConfigCar.acrissCarCode1.getAll.ligneParPage) ;
            });
        };


        ctrl.code1.add = function () {
            ctrl.code1.element.id = null;
            acrissCarCode1Service.add(ctrl.code1.element).then(function(data){
                if(!data.errors){
                    console.log(ctrl.code1.element) ;
                    ctrl.code1.element = data ;
                    ctrl.code1.errors = null ;

                    ctrl.code1.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.code1.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.code1.element = null ;
                    ctrl.code1.errors = data ;
                }
                ctrl.code1.viewAll();
                ctrl.devis.element ={};
            });
            ctrl.code2.element ={};
        };


        ctrl.code1.update = function(el){
            acrissCarCode1Service.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.code1.element = data ;
                    //ctrl.code1.errors = null ;
                    ctrl.code1.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.code1.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.code1.viewAll();
                ctrl.devis.element ={};
            })
            ctrl.code1.editingData[el.element.code]  = false;
            ctrl.code2.element ={};
        };

        ctrl.code1.remove = function(el){
            acrissCarCode1Service.remove(el.element).then(function(data) {
                ctrl.code1.messageInfo =  data;
                console.log("--messageInfo--- debut---" + ctrl.code1.messageInfo);
                /*setInterval(function(){  //setTimeout
                    console.log("--messageInfo----");
                }, 2000);*/
                $timeout(function () {
                    console.log("---timeout---"+ctrl.code1.messageInfo );
                    ctrl.code1.messageInfo = false;
                }, 2000);
                ctrl.devis.element ={};
                ctrl.code1.viewAll();
            });
            ctrl.code2.element ={};


        };



    }]);
