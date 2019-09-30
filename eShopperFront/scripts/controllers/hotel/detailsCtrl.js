app.controller('detailsCtrl', ['$scope','coordFactory','hotelFactory2','$http', function($scope,coordFactory,hotelFactory2,$http) {

$scope.hotels=hotelFactory2.hotels;
$scope.cpt=hotelFactory2.cpt
$scope.list=$scope.hotels.data.results[$scope.cpt].amenities

}])