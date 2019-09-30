app.factory('vol', ['$resource', function ($resource) {

        return $resource('http://localhost:8084/eShopperBack/api/avion/vol/:id', {id: '@id'})
        
    }]);