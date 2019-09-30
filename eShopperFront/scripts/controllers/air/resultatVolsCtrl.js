app.controller('resultatRechercheAvionCtrl', ['$scope', 'vols', 'airports', 'Pagination', 'reservationVol', function ($scope, vols, airports, Pagination, reservationVol) {

        //code pour la récupération des infos de l'api de reservation vol
        $scope.vols = {};
        $scope.vols = vols.results;


        //code pour la récupération des infos de l'api autocomplet airports
        $scope.airportResults = {};
        $scope.airportResults = airports.airportResults

        //fonction qui fais passer les données de la reservation vers la factory reservationVol
        $scope.reserver = function (reservation) {
            reservationVol.resultVol = reservation;
        }

        //code pour la pagination
        $scope.pagination = Pagination.getNew(10);
        $scope.pagination.numPages = 0
        $scope.$watch(
                function () {
                    return $scope.pagination.numPages = Math.ceil($scope.vols.results.length / $scope.pagination.perPage);
                },
                function () {
                    $scope.vols != null;
                }
        );

    }]);