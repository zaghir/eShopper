app.factory('hotelFactory2', function($http,$q){ // liée à ctrl3
	var cpt=''
	var hotels={}
	var radius=''
	var ville=''
	var check_in=''
	var check_out=''
	var number='';
	var prixmin='';
	var prixmax='';
	var people=''
	var piscine={};
	var parking={}
	var restaurant={}
	var pets = {}
	
function gett(urll){
	
	return	$http({
			method : 'GET',
			url : "https://api.sandbox.amadeus.com/v1.2/hotels/search-circle?"+urll

		})
		.then(function(data){
			return data;
		})
		.catch(function(response){
		 return	$q.reject("Fail :)", response.status);
		})
		
	}

	return {
		gett : gett
	}
})