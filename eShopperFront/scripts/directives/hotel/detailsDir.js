app.directive('detailsDir', function(){

	return {

		templateUrl :'views/hotel/detailsTemplate.html',
		replace : false,		// boolean. Changement de lecture dans le DOM
		restrict : 'AECM',	// Comment déclarer la directive A E C M

		scope : {
			amenities : '='
		
		}

	}
})