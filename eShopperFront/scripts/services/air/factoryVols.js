app.factory('vols', ['$resource', function ($resource) {
        function gett(urll) {
            return $resource('https://api.sandbox.amadeus.com/v1.2/flights/affiliate-search/v1.2/flights/affiliate-search?apikey=tZd8BKro0UPnoyXLJAk1v1ub6FQTu08e' + urll);
        }
        return {gett: gett}
    }]);