app.factory('reservationVol', ['$resource', function ($resource) {

        return $resource('http://localhost:8084/eShopperBack/api/avion/reservationVol/:id', {id: '@id'})
        
    }]);