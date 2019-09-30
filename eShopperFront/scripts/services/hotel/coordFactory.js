app.factory('coordFactory', function($resource,$http,$q){

	var lat=''
	var lng=''
	function getCoord(urll){
	return	$http({
			method : 'GET',
			url : "https://www.mapquestapi.com/geocoding/v1/address?"+urll

		})
		.then(function(data){
			return data;
		})
		.catch(function(response){
		 return	$q.reject("Fail :)", response.status);
		})

	}

	return {
		getCoord : getCoord
	}
}
)