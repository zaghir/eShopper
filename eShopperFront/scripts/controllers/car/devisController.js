/**
 * Created by yzaghir on 27/06/2016.
 */
angular.module("eShopperApp").controller("devisController" , ["$state" ,"$timeout" , "devisService" ,"paginationService", "CConfigCar" ,
    function($state , $timeout, devisService  , paginationService , CConfigCar){

        var ctrl = this ;

        ctrl.devis = {};
        ctrl.devis.editingData = {};
        ctrl.devis.data = [];
        ctrl.devis.pageCourante = 1 ;

        ctrl.devis.goToPage=function(numeroPage){
            ctrl.devis.pageCourante = numeroPage ;
            ctrl.devis.data = paginationService.getOnePage(ctrl.devis.data , ctrl.devis.pageCourante);

        };

        ctrl.devis.modify = function(el) {
            ctrl.devis.editingData[el.element.id] = true;
        };

        ctrl.devis.viewAll = function(){
            devisService.apiRest().then(function(data){
                ctrl.devis.data = paginationService.getPagination(data , CConfigCar.devis.getAll.ligneParPage) ;
            });
        };


        ctrl.devis.add = function () {
            console.log(ctrl.devis.element) ;
            ctrl.devis.element.id = null;
            devisService.add(ctrl.devis.element).then(function(data){
                if(!data.errors){
                    ctrl.devis.element = data ;
                    ctrl.devis.errors = null ;

                    ctrl.devis.messageInfo =  "Add Ok!";
                    $timeout(function () {
                        ctrl.devis.messageInfo = false;
                    }, 2000);
                }else{
                    ctrl.devis.element = null ;
                    ctrl.devis.errors = data ;
                }
                ctrl.devis.viewAll();
            });
            ctrl.devis.element ={};

        };


        ctrl.devis.update = function(el){
            devisService.update(el.element).then(function(data){
                if(!data.errors){
                    //ctrl.devis.element = data ;
                    //ctrl.devis.errors = null ;
                    ctrl.devis.messageInfo =  "Update Ok!";
                    $timeout(function () {
                        ctrl.devis.messageInfo = false;
                    }, 2000);
                }else{
                    el.errors = data ;
                }
                ctrl.devis.viewAll();
            })
            ctrl.devis.editingData[el.element.id]  = false;
            ctrl.devis.element ={};
        };

        ctrl.devis.remove = function(el){
            devisService.remove(el.element).then(function(data) {
                ctrl.devis.messageInfo =  data;
                $timeout(function () {
                    ctrl.devis.messageInfo = false;
                }, 2000);

                ctrl.devis.viewAll();
            });
            ctrl.devis.element ={};
        };

    }]);
