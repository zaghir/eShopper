app.factory('facture', ['$resource', function ($resource) {

        return $resource('http://localhost:8084/eShopperBack/api/avion/facture/:id', {id: '@id'})
        
    }]);