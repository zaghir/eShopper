'use strict';

/**
 * @ngdoc function
 * @name eShopperApp.controller:MessageCtrl
 * @description
 * # MessageCtrl
 * Controller of the eShopperApp
 */

 app.controller('contactCtrl', function ($http, $scope) {

            //les attributs
            $scope.errors = null;
            $scope.message = {};
            $scope.exception = {message: null};
            $scope.mode = {
                value: 'form' 
            };

            //methode1: Enregistrer un message
            $scope.saveMessage = function () {
                $http.post("http://localhost:8080/messages", $scope.message)
                        .success(function (data) {
                            if (!data.errors) {
                                $scope.message = data;
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
