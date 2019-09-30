app.directive('hotelDir', function(){

	return {

		templateUrl :'views/hotel/hotelTemplate.html',
		replace : false,		// boolean. Changement de lecture dans le DOM
		restrict : 'AECM',	// Comment déclarer la directive A E C M

		scope : {
			resultat : "=",
			compteFunction : '&',
			prixmin : '=',
			prixmax : '=',
			people : '=',
			piscine : '=',
			parking : '=',
			pets : '=',
			restaurant : '='
	
		}
		
	}
})