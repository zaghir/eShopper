app.controller('errorCtrl',['$scope','$state', 'errorFactory', function($scope,$state,errorFactory){

	$scope.compteur=errorFactory.compteur
	
	console.log($scope.compteur)
	$scope.charger= function(){
		$scope.compteur=$scope.compteur+1
		errorFactory.compteur=$scope.compteur
		console.log($scope.compteur)
	}
	$scope.charger()
}])