app.factory('CityFinder', function ($resource) {
  var CityID = $resource('http://api.sandbox.amadeus.com/v1.2/rail-stations/autocomplete', {}, {
    get: { method: 'GET' }
  });
  return CityID;
})