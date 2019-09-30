app.controller('rechercheVolsCtrl', ['$scope', '$state', 'vols', 'airports', 'reservationVol', function ($scope, $state, vols, airports, reservationVol) {

    $scope.departure_airport = 'Paris Orly Airport';
    $scope.destination_airport = 'Algiers Houari Boumediene Airport';
    $scope.urlAirport = '';
    $scope.origin = '';
    $scope.destination = '';
    $scope.departure_date = new Date();
    $scope.return_date = new Date();
    $scope.adults = '1';
    $scope.children = '0';
    $scope.infants = '0';
    $scope.max_price = '';
    $scope.mobility = 'false';
    $scope.url = '';



    $scope.$watch('departure_airport',
            function () {

                $scope.urlAirport = '&term=' + $scope.departure_airport;
                $scope.airportResults = airports.getAirport($scope.urlAirport).query();
                $scope.airportResults.$promise
                        .then(function () {

                            for (var i = 0; i < $scope.airportResults.length; i++) {
                                $scope.airportResults[i].label = $scope.airportResults[i].label.split('[')[0]
                            }
                            airports.airportResults = $scope.airportResults;
                        })
                        .catch(function () {
                            // failure
                            console.log('Erreur d\'execution airports.getAirport($scope.urlAirport).query(): ');
                        });
            }
    );
    $scope.$watch('destination_airport',
            function () {

                $scope.urlAirport = '&term=' + $scope.destination_airport;
                $scope.airportResults = airports.getAirport($scope.urlAirport).query();
                $scope.airportResults.$promise
                        .then(function () {
                            for (var i = 0; i < $scope.airportResults.length; i++) {
                                $scope.airportResults[i].label = $scope.airportResults[i].label.split('[')[0]
                            }
                            airports.airportResults = $scope.airportResults;
                        })
                        .catch(function () {
                            // failure
                            console.log('Erreur d\'execution airports.getAirport($scope.urlAirport).query(): ');
                        });
            }
    );

    $scope.submit = function () {

        $scope.urlAirport = '&term=' + $scope.destination_airport;
        $scope.airportResults = airports.getAirport($scope.urlAirport).query();
        $scope.airportResults.$promise
                .then(function () {
                    // success
                    airports.airportResults = $scope.airportResults;
                    $scope.destination = $scope.airportResults[0].value;
                    console.log($scope.airportResults[0].value)
                    $scope.url = '&destination=' + $scope.destination

                    $scope.urlAirport = '&term=' + $scope.departure_airport;
                    $scope.airportResults = airports.getAirport($scope.urlAirport).query();
                    $scope.airportResults
                            .$promise
                            .then(function () {
                                // success
                                var dtDepart = new Date($scope.departure_date);
                                var dtRetour = new Date($scope.return_date);

                                var departure_date = dtDepart.getFullYear() + "-" + ("0" + (dtDepart.getMonth() + 1)).slice(-2) + "-" + dtDepart.getDate()
                                var return_date = dtRetour.getFullYear() + "-" + ("0" + (dtRetour.getMonth() + 1)).slice(-2) + "-" + dtRetour.getDate()

                                airports.airportResults = $scope.airportResults;
                                $scope.origin = $scope.airportResults[0].value;
                                $scope.url = '&origin=' + $scope.origin
                                        + '&destination=' + $scope.destination
                                        + '&departure_date=' + departure_date
                                        + '&adults=' + $scope.adults
                                        + '&children=' + $scope.children
                                        + '&infants=' + $scope.infants
                                        + '&mobile=' + $scope.mobility;
                                if ($scope.max_price != '') {
                                    $scope.url = $scope.url + '&max_price=' + $scope.max_price;
                                }
                                if ($scope.return_date != '') {
                                    $scope.url = $scope.url + '&return_date=' + return_date;
                                }
                                $scope.results = vols.gett($scope.url).get();
                                $scope.results.$promise
                                        .then(function () {
                                            // success
                                            vols.results = $scope.results;

                                            if ($state.current.name == 'resultatAvion') {
                                                $state.reload();
                                            } else {
                                                $state.go('resultatAvion');
                                            }
                                        })
                                        .catch(function () {
                                            // failure
                                            console.log('Erreur d\'execution vols.gett($scope.url).get()');
                                        });


                            })
                            .catch(function (response) {
                                // failure
                                console.log('Erreur d\'execution airports.getAirport($scope.urlAirport).query(): ');
                            });

                })
                .catch(function () {
                    // failure
                    console.log('Erreur de recupération de la destination');
                });



    };

    $scope.hoverIn = function () {
        this.hoverEdit = true;
    };

    $scope.hoverOut = function () {
        this.hoverEdit = false;
    };
}]);