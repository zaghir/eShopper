app.controller('ctrl4', ['$scope', 'hotelFactory2','$http','coordFactory', '$state', 'Pagination', function($scope,hotelFactory2,$http,coordFactory,$state, Pagination) {

$scope.cpt=hotelFactory2.cpt
$scope.results=hotelFactory2.hotels
$scope.radius=hotelFactory2.radius
$scope.check_in=hotelFactory2.check_in
$scope.check_out=hotelFactory2.check_out
$scope.number=hotelFactory2.number
$scope.ville=hotelFactory2.ville

$scope.prixmin=hotelFactory2.prixmin
$scope.prixmax=hotelFactory2.prixmax
$scope.people=hotelFactory2.people

$scope.piscine=hotelFactory2.piscine
$scope.pets=hotelFactory2.pets
$scope.parking=hotelFactory2.parking
$scope.restaurant=hotelFactory2.restaurant

//code pour la pagination
$scope.pagination = Pagination.getNew(10);
$scope.pagination.numPages = 0
$scope.$watch(
        function () {
            return $scope.pagination.numPages = Math.ceil($scope.results.data.results.length / $scope.pagination.perPage);
        },
        function () {
            $scope.results.data.results != null;
        }
);

}])