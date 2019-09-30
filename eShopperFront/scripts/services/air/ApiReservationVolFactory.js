app.factory('reservationVol', ['$resource', function ($scope, $resource) {

        var service = {
            resultVol: "defaultVolResult",
        }
        return service;
    }]);