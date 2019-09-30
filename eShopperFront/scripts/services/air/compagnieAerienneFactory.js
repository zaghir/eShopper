app.factory('compagnieAerienne', ['$resource', function ($resource) {

        return $resource('http://localhost:8084/eShopperBack/api/avion/compagnieAerienne/:id', {id: '@id'})
        
    }]);