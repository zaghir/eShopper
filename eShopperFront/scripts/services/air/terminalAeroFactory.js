app.factory('terminalAero', ['$resource', function ($resource) {

        return $resource('http://localhost:8084/eShopperBack/api/avion/terminalAero/:id', {id: '@id'})
        
    }]);