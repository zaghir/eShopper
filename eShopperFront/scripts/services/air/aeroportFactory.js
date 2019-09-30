app.factory('aeroport', ['$resource', function ($resource) {


        function getAeroport(avionDinamicUrl) {
            return $resource(avionDinamicUrl, {id: '@id'});
        }
        return {getAeroport: getAeroport}
    }]);