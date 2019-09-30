app.factory('tarif', ['$resource', function ($resource) {

        return $resource('http://localhost:8084/eShopperBack/api/avion/tarif/:id', {id: '@id'})
        
    }]);