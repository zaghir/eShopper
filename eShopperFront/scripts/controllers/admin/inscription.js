'use strict';

/**
 * @ngdoc function
 * @name eShopperApp.controller:ClientCtrl
 * @description
 * # ClientCtrl
 * Controller of the eShopperApp
 */
app.controller('inscriptionCtrl', function ($http, $scope) {
            
            //les attributs
            $scope.errors = null;
            $scope.client = {};
            $scope.exception = {message: null};
            $scope.mode = {
                value: 'form'
            };

            //methode1: Enregistrer un client
            $scope.saveClient = function () {
                $http.post("http://localhost:8080/clients", $scope.client)
                        .success(function (data) {
                            if (!data.errors) {
                                $scope.client = data;
                                $scope.errors = null;
                                $scope.mode.value = "confirm";
                            } else {
                                $scope.errors = data;
                            }
                            ;
                        }).error(function (data) {
                    $scope.exception.message = data.message;
                });
            };      
        });
