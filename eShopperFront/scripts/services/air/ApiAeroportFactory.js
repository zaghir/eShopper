app.factory('airports', ['$resource', function ($resource) {
        function getAirport(terme) {return $resource('https://api.sandbox.amadeus.com/v1.2/airports/autocomplete?apikey=tZd8BKro0UPnoyXLJAk1v1ub6FQTu08e' + terme);
        }
        return { getAirport: getAirport}
    }]);