
angular.module('eShopperApp').factory('formFact', [ function(){

	var getField = function(pay){

		var t = [];                             // t tableau
		var f;               		 			// f field
		var c = "";					 			// c chain
		var k = "Mysecretsig1875!?"; 			// k key
			
		for(f in pay){

			t.push(f);							//tableau peuplé des données du formulaire
			t.sort();                            // Champs du tableau ordonnés par ordre alphabétique
		};			

		t.forEach(function(f){

			if(pay[f] !== undefined){

					c += f + "=" + pay[f] + k; //construction de la chaine à crypter
			}
		});
		return c; //chaine cryptée
	};
	return {
		getField : getField
	};

}]);