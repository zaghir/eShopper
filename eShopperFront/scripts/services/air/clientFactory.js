app.factory('client', ['$resource', function ($resource) {

           function getClient(avionDinamicUrl) {
            return $resource(avionDinamicUrl, {id: '@id'});
        }
        return {getClient: getClient}
    }]);