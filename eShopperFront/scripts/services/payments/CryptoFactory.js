

angular.module('eShopperApp').factory('cryptFact', [ function(){

	var genereCode = function(value){

	var str = CryptoJS.SHA1(value).toString().toUpperCase();
	return str;
	};

	return {
			genereCode : genereCode
	};
}]);