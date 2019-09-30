angular.module('eShopperApp').factory('CConfigCar' ,["$location", 
		function($location){

	var appName =  "eShopperBack";
	var constUrl = $location.protocol() +"://"+$location.host() ;
	if($location.port() != "80"){
		constUrl += ":"+$location.port();
	}
	constUrl += ":8080";
	constUrl +="/"+appName ;
	
	var service = {
		acrissCarCode1 : {
		    url: constUrl+'/api/vehicule/acrissCarCode1',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  },
		  acrissCarCode2 : {
		    url: constUrl+'/api/vehicule/acrissCarCode2',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  },
		  acrissCarCode3 : {
		    url: constUrl+'/api/vehicule/acrissCarCode3',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  },
		  acrissCarCode4 : {
		    url: constUrl+'/api/vehicule/acrissCarCode4',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  },
		  agenceAuto : {
		    url: constUrl+'/api/vehicule/agenceAuto',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  } ,
		  compagnie : {
		    url: constUrl+'/api/service/compagnieVehicule',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  } ,
		  devis : {
		    url: constUrl+'/api/vehicule/devis',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  } ,
		  tarifs : {
		    url: constUrl+'/api/vehicule/tarifsVehicule',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  } ,
		  vehicule : {
		    url: constUrl+'/api/vehicule/vehicule',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  } ,
		  reservation : {
		    url: constUrl+'/api/vehicule/reservationVehicule',
		    getAll: {
		      ligneParPage: 5
		    },
		    add: {},
		    update: {},
		    remove: {}
		  }
    };
    return service ;
	
}]);

