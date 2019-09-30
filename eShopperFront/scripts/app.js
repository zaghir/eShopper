'use strict';

/**
 * @ngdoc overview
 * @name eShopperApp
 * @description
 * # eShopperApp
 *
 * Main module of the application.
 */
var app = angular.module('eShopperApp', [
    'ngAnimate',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.router',
    'ui.bootstrap',
    'simplePagination'
])
app.config(function ($stateProvider) {
    $stateProvider									//partie hotel
            .state("pay", {
				templateUrl: "views/payments/pay.html",
                url: "/pay",
                controller: 'payCtrl'
			})
			.state("hotel", {
                templateUrl: "views/hotel/recherche.html",
                url: "/hotel",
                controller: 'ctrl3'
            })
            .state("resultat", {
                parent: 'hotel',
                templateUrl: "views/hotel/resultat.html",
                controller: "ctrl4"
            })
            .state('attente', {
                parent: 'hotel',
                template: '<div></div>'
            })
            .state("details", {
                templateUrl: "views/hotel/details.html",
                url: "/details",
                controller: "detailsCtrl"
            })
            .state("accueil", {               //partie accueil
                templateUrl: 'views/admin/accueil.html',
                url: "/accueil"
            })
            .state("contact", {               //partie contact
                templateUrl: 'views/admin/contact.html',
                controller: 'contactCtrl',
                controllerAs: 'contact',
                url: '/contact'
            })
            .state('connexion', {               //partie s'identifier
                templateUrl: 'views/admin/login.html',
                controller: 'loginCtrl',
                controllerAs: 'loginCtrl',
                url: '/connexion'
            })
            .state('inscription', {
                templateUrl: 'views/admin/inscription.html',
                controller: 'inscriptionCtrl',
                controllerAs: 'inscriptionCtrl',
                url: '/inscription'
            })            
            .state("compagnieVehicule" , {          // partie vehicule
                url:"/compagnieVehicule",
                templateUrl : "views/car/tpl-admin-compagnie-vehicule.html",
                controller :"compagnieVehiculeController",
                controllerAs :"compVCtrl"
            })
            .state("agenceAuto" , {
                url:"/agenceAuto" ,
                templateUrl :"views/car/tpl-admin-agenceAuto.html",
                contoller : "agenceAutoController" ,
                controllerAs : "agCtrl"
            })
            .state("vehicule" ,{
                url:"/vehicule" ,
                templateUrl :"views/car/tpl-admin-vehicule.html",
                contoller : "vehiculeController" ,
                controllerAs : "vehiCtrl"
            })
            .state("optionsCode1Vehicule" , {
                url:"/optionsCode1Vehicule" ,
                templateUrl :"views/car/tpl-admin-optionsCode1Vehicule.html",
                contoller : "optionsCode1VehiculeController" ,
                controllerAs : "opv1Ctrl"
            })
            .state("optionsCode2Vehicule" , {
                url:"/optionsCode2Vehicule" ,
                templateUrl :"views/car/tpl-admin-optionsCode2Vehicule.html",
                contoller : "optionsCode2VehiculeController" ,
                controllerAs : "opv2Ctrl"
            })
            .state("optionsCode3Vehicule" , {
                url:"/optionsCode3Vehicule" ,
                templateUrl :"views/car/tpl-admin-optionsCode3Vehicule.html",
                contoller : "optionsCode3VehiculeController" ,
                controllerAs : "opv3Ctrl"
            })
            .state("optionsCode4Vehicule" , {
                url:"/optionsCode4Vehicule" ,
                templateUrl :"views/car/tpl-admin-optionsCode4Vehicule.html",
                contoller : "optionsCode4VehiculeController" ,
                controllerAs : "opv4Ctrl"
            })
            .state("reservationAdminVehicule" , {
                url:"/reservationAdminVehicule" ,
                templateUrl :"views/car/tpl-admin-reservationVehicule.html",
                contoller : "reservationAdminVehiculeContoller" ,
                controllerAs : "resvCtrl"
            })
            .state("rechercheVehicule" , {
                url:"/rechercheVehicule" ,
                templateUrl :"views/car/tpl-recherche-vehicule.html",
                contoller : "rechercheVehiculeController" ,
                controllerAs : "rechvCtrl"
            })
            .state("reservationVehicule" , {
                url:"/reservationVehicule" ,
                templateUrl :"views/car/tpl-reservation-vehicule.html",
                contoller : "reservationVehiculeController" ,
                controllerAs : "reservationVehCtrl"
            })
            .state("devis" , {
                url:"/devis" ,
                templateUrl :"views/car/tpl-admin-devis.html",
                contoller : "devisController" ,
                controllerAs : "rechvCtrl"
            })
            .state("tarifsVehicule" , {
                url:"/tarifsVehicule" ,
                templateUrl :"views/car/tpl-admin-tarifsVehicule.html",
                contoller : "tarifsVehiculeController" ,
                controllerAs : "tarifsVCtrl"
            })
            .state("reportReservationVehicule" , {
              url:"/reportReservationVehicule" ,
              templateUrl :"views/car/tpl-report-reservation-vehicule.html",
              contoller : "reportReservationVehiculeController" ,
              controllerAs : "reportVCtrl"
            })
            .state("avion", {                       //partie avion
                url: "/avion",
                templateUrl: "views/air/formRechercheVols.html",
                controller: "rechercheVolsCtrl",
                controllerAs: "rechercheVolsCtrl"
            })
            .state("resultatAvion", {
                parent: 'avion',
                templateUrl: "views/air/resultatVols.html",
                controller: "resultatRechercheAvionCtrl",
                controllerAs: "resultatRechercheAvionCtrl"
            })
            .state("reservationAvion", {
                url: "/reservationAvion",
                templateUrl: "views/air/formResrvation.html",
                controller: "reservationVolCtrl",
            })
            .state('train',{                        //partie train
            	templateUrl :'views/rail/travel.html',
            	controller : 'travelController',
            	url : '/train'
            })
            .state('journey',{
                templateUrl :'views/rail/journey.html',
                controller : 'journeyCtrl',
                url : '/journey'
            })
            .state("payments" ,{
                url:"/payments" ,
                templateUrl :"views/payments/pay.html",
                contoller : "payController" ,
                controllerAs : "payCtrl"
            })           
            .state('otherwise', {							//si erreur
                url : '*path',
                templateUrl : '404.html',
                controller : 'errorCtrl'
            })


})
