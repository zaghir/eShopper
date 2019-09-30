app.controller('ctrl3', ['$scope', 'hotelFactory2','$http','coordFactory', '$state', function($scope,hotelFactory2,$http,coordFactory,$state) {

	$scope.ok=false
	$scope.url=''
	$scope.results=''
	$scope.radius='10'
	$scope.check_in=new Date()
	$scope.check_out=new Date();
	$scope.number='5000'
	$scope.ville=''	
	$scope.prixmin=0
	$scope.prixmax=''
	$scope.people='1'
	$scope.currency='EUR'

	$scope.piscine={
		choix : 'non',
		value : 'POOL',
		affiche : false
	}

	$scope.pets ={
		choix :'non',
		value : 'PETS_ALLOWED',
		affiche : false
	}
	
	$scope.restaurant ={
		choix : 'non',
		value : 'RESTAURANT',
		affiche : false
	}
	
	$scope.parking ={
		choix :'non',
		value : 'PARKING',
		affiche : false
	}
	
	$scope.champs=false

	$scope.moreChamps = function(){
		if($scope.champs==false){
			$scope.champs=true
		}
		else{
			$scope.champs=false
		}
	}

	$scope.search = function(){
	
		$scope.url="key=Kl4eaToek5yMv6Xskc0vvXhD1YlpuMpa&location="+$scope.ville
	
		$state.transitionTo('attente')
	
		var dateIn = new Date($scope.check_in);
        var dateOut = new Date($scope.check_out);
        
        check_in = dateIn.getFullYear() + "-" + ("0" + (dateIn.getMonth() + 1)).slice(-2) + "-" + dateIn.getDate()
        check_out = dateOut.getFullYear() + "-" + ("0" + (dateOut.getMonth() + 1)).slice(-2) + "-" + dateOut.getDate()
        
		coordFactory.getCoord($scope.url)
		.then(function(data){
			$scope.result=data
			coordFactory.lng=data.data.results[0].locations[0].displayLatLng.lng
			coordFactory.lat=data.data.results[0].locations[0].displayLatLng.lat
	
			$scope.url ="apikey=Ygo2aHHaAGDJaAfNafvjXUOhUrhGvVAp&latitude="+coordFactory.lat+"&longitude="+coordFactory.lng+"&radius="+$scope.radius+"&check_in="+check_in+"&check_out="+check_out+"&number_of_results="+$scope.number+"&currency="+$scope.currency
			if($scope.piscine.choix=='oui'){
				$scope.url=$scope.url+'&amenity='+$scope.piscine.value
				$scope.piscine.affiche=true
			}
			if($scope.parking.choix=='oui'){
				$scope.url=$scope.url+'&amenity='+$scope.parking.value
				$scope.parking.affiche=true
			}
			if($scope.pets.choix=='oui'){
				$scope.url=$scope.url+'&amenity='+$scope.pets.value
				$scope.pets.affiche=true
			}
			if($scope.restaurant.choix=='oui'){
				$scope.url=$scope.url+'&amenity='+$scope.restaurant.value
				$scope.restaurant.affiche=true
			}
			if($scope.piscine.choix=='non'){
			
				$scope.piscine.affiche=false
			}
			if($scope.parking.choix=='non'){
			
				$scope.parking.affiche=false
			}
			if($scope.pets.choix=='non'){
			
				$scope.pets.affiche=false
			}
			if($scope.restaurant.choix=='non'){
			
				$scope.restaurant.affiche=false
			}
			console.log($scope.url)
		
			hotelFactory2.gett($scope.url)
			.then(function(data){
				$scope.results=data;
				
				for (var i=0; i< $scope.results.data.results.length;i++){
			
					if ($scope.results.data.results[i].rooms[0].room_type_info.bed_type=='Single'){
						$scope.results.data.results[i].places=$scope.results.data.results[i].rooms[0].room_type_info.number_of_beds
					}
					else{
						$scope.results.data.results[i].places=$scope.results.data.results[i].rooms[0].room_type_info.number_of_beds*2
					}
				}
		
				$state.transitionTo('resultat')
		
			
			hotelFactory2.hotels=data
			console.log(hotelFactory2.hotels)
		
			hotelFactory2.radius=$scope.radius
			hotelFactory2.check_in=$scope.check_in
			hotelFactory2.check_out=$scope.check_out
			hotelFactory2.number=$scope.number
			hotelFactory2.ville=$scope.ville
			hotelFactory2.prixmin=$scope.prixmin
			hotelFactory2.prixmax=$scope.prixmax
			hotelFactory2.people=$scope.people
			hotelFactory2.places=$scope.places
			hotelFactory2.piscine=$scope.piscine
			hotelFactory2.parking=$scope.parking
			hotelFactory2.pets=$scope.pets
			hotelFactory2.restaurant=$scope.restaurant
	
		})
		.catch(function(msg){
			console.log(msg);
		})
	
		
		})
	
		.catch(function(msg){
			console.log(msg);
		})
	
	
		$scope.ok=true
		$scope.url=''
	}

	$scope.cpt=''

	$scope.compte=function(result){
	
	
	console.log($scope.results.data.results.indexOf(result))
	$scope.cpt = $scope.results.data.results.indexOf(result)
	
	hotelFactory2.cpt=$scope.cpt
	}


	$scope.init = function(){
		$scope.ok=false
		$scope.url=''
		$scope.results=''
		$scope.radius='10'
		$scope.check_in=new Date()
		$scope.check_out=new Date()
		$scope.number='200'
		$scope.ville=''
		coordFactory.lng=''
		coordFactory.lat=''
		$scope.prixmin=''
		$scope.prixmax=''
		$scope.piscine='non'
		$scope.champs=false
		
		$scope.piscine={
			choix : 'non',
			value : 'POOL'
		}
		
		$scope.pets ={
			choix :'non',
			value : 'PETS_ALLOWED'
		}
		
		$scope.restaurant ={
			choix : 'non',
			value : 'RESTAURANT'
		}
		
		$scope.parking ={
			choix :'non',
			value : 'PARKING'
		}
		
		$scope.currency='EUR'
	}

}])


