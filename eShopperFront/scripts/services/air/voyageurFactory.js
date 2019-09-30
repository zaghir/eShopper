app.factory('voyageur', ['$resource', function ($resource) {


        function getVoyageur(avionDinamicUrl) {
            return $resource(avionDinamicUrl, {id: '@id'});
        }
        return {getVoyageur: getVoyageur}

    }]);