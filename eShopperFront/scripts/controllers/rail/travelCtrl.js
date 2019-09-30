
app.controller('travelController',['$scope','$rootScope','$location','$resource','citiesService','CityFinder','Pagination','$routeParams','HourFinder','PriceFinder','ComputeDuration','Comparator','BookingInformation',
  function($scope,$rootScope,$location,$resource,citiesService,CityFinder,Pagination,$routeParams,HourFinder,PriceFinder,ComputeDuration,Comparator,BookingInformation){
       

       $scope.$watch('city_departure',function(){
         	// update cityservice to the current value of the scope
         	citiesService.city_departure=$scope.city_d;
       });
       $scope.city_d=citiesService.city_departure;
       $scope.$watch('city_arrival',function(){
     	   // update cityservice to the current value of the scope
     	   citiesService.city_arrival=$scope.city_a;
       });
        $scope.city_a=citiesService.city_arrival;

        $scope.submit_departure = function(){
     	     $scope.trainResult = CityFinder.query({term:$scope.city_d,apikey:'gDTgXILsDzSDpvqYdZlxgOGRD8TztoZh'});
        };
        $scope.submit_arrival = function(){
           $scope.trainResult = CityFinder.query({term:$scope.city_a,apikey:'gDTgXILsDzSDpvqYdZlxgOGRD8TztoZh'});
        };
       
        $scope.date_d = new Date();
        $scope.date_r = new Date();

       

       $scope.hourCondition ={
         operator_a : HourFinder.heureCondition.operator_a ,
         operator_r : HourFinder.heureCondition.operator_r
       } ;
       $scope.operators = HourFinder.heures;

      
       $scope.priceCondition={
        operator_price : PriceFinder.priceCondition.operator_price
       };
       $scope.prices=PriceFinder.prices;

       

       $scope.ComparingPrices=function(a,b){
              return Comparator.comparer_prix(a,b);
           }
       $scope.ComparingTwoNumbers=function(a,b){
              return Comparator.comparer_nombres(a,b);
         }
       $scope.type_trip='';
      
     $scope.extensiveSubmit=function(){
        $scope.items_d=[];
        $scope.items_a=[];
 
      
        $scope.extensiveTrainAPI= $resource("https://api.sandbox.amadeus.com/v1.2/trains/extensive-search");
        var response_d = CityFinder.query({term:$scope.city_d,apikey:'gDTgXILsDzSDpvqYdZlxgOGRD8TztoZh'});
        var response_a = CityFinder.query({term:$scope.city_a,apikey:'gDTgXILsDzSDpvqYdZlxgOGRD8TztoZh'});
          response_d.$promise.then(function(data){
             $scope.items_d = data;
     
              response_a.$promise.then(function(data){
                $scope.items_a =data;
              
                $scope.extensiveTrainResult_a = $scope.extensiveTrainAPI.get({apikey:'gDTgXILsDzSDpvqYdZlxgOGRD8TztoZh',
                                                                    origin: $scope.items_d[0].value,//$scope.ville_depart, 
                                                                    destination: $scope.items_a[0].value, //$scope.ville_arrivee,
                                                                    departure_date: $scope.date_d//$scope.date_depart
                                                                });
                $scope.extensiveTrainResult_a.$promise.then(function(data){
                    $scope.initial="";
                    $scope.trips_number_a="";
                    $scope.min="";
                    $scope.current_price="";
                    $scope.ville_origin="";
                    $scope.ville_destination="";
                    $scope.heure_origin="";
                    $scope.heure_destination="";
                    $scope.trips_number_a=data.results[0].itineraries;
                    //console.log($scope.trips_number_a[0])
                    $scope.show_me=true;
                    $scope.initial=data.results[0].itineraries[0].trains[0].prices[0].total_price.amount;
                  
                    $scope.min=$scope.initial;
                   // console.log($scope.initial)
                    for (i = 1; i < $scope.trips_number_a.length; i++){
                        $scope.current_price=$scope.trips_number_a[i].trains[0].prices[0].total_price.amount;
                        $scope.city_origin=$scope.trips_number_a[i].trains[0].departure_station.station_name;
                        $scope.city_destination=$scope.trips_number_a[i].trains[0].arrival_station.station_name;
                        $scope.time_departure=$scope.trips_number_a[i].trains[0].departs_at;
                        $scope.time_arrival=$scope.trips_number_a[i].trains[0].arrives_at;
                        if (parseInt($scope.current_price)<parseInt($scope.min)){
                          $scope.min=$scope.current_price;
                          $scope.ville_origin=$scope.city_origin;
                         
                          $scope.ville_destination=$scope.city_destination;
                          
                          $scope.heure_origin=$scope.time_departure;
                          
                          $scope.heure_destination=$scope.time_arrival;
                          
                        }
                       
                    }
                    if($scope.priceCondition.operator_price==300 
                      && $scope.hourCondition.operator_a=='00:00'){
                         $scope.pagination_a = Pagination.getNew(4);
                    }
                    else{
                         $scope.pagination_a = $scope.trips_number_a.length;
                    }
                     
                    $scope.pagination_a.numPages = 0
                    
                     $scope.$watch(
                      function () {
                         return $scope.pagination_a.numPages = Math.ceil($scope.trips_number_a.length / $scope.pagination_a.perPage);
                    
                                  },
                      function () {
                            $scope.trips_number_a != null;
                            
                                  }
                                 );
                })
                if($scope.type_trip=='Aller-retour'){
                $scope.extensiveTrainResult_r = $scope.extensiveTrainAPI.get({apikey:'gDTgXILsDzSDpvqYdZlxgOGRD8TztoZh',
                                                                    origin: $scope.items_a[0].value,//$scope.ville_depart, 
                                                                    destination: $scope.items_d[0].value, //$scope.ville_arrivee,
                                                                    departure_date: $scope.date_r//$scope.date_depart
                                                                });
                $scope.extensiveTrainResult_r.$promise.then(function(data){
                    $scope.initial_r="";
                    $scope.trips_number_r="";
                    $scope.min_r="";
                    $scope.current_price_r="";
                    $scope.ville_origin_r="";
                    $scope.ville_destination_r="";
                    $scope.heure_origin_r="";
                    $scope.heure_destination_r="";
                    $scope.trips_number_r=data.results[0].itineraries;
                    $scope.show_me_r=true;
                    $scope.initial_r=data.results[0].itineraries[0].trains[0].prices[0].total_price.amount;
                    $scope.min_r=$scope.initial_r;
                     for (j = 1; j < $scope.trips_number_r.length; j++){
                        $scope.current_price_r=$scope.trips_number_r[j].trains[0].prices[0].total_price.amount;
                        $scope.city_origin_r=$scope.trips_number_r[j].trains[0].departure_station.station_name;
                        $scope.city_destination_r=$scope.trips_number_r[j].trains[0].arrival_station.station_name;
                        $scope.time_departure_r=$scope.trips_number_r[j].trains[0].departs_at;
                        $scope.time_arrival_r=$scope.trips_number_r[j].trains[0].arrives_at;
                        if (parseInt($scope.current_price_r)<parseInt($scope.min_r)){
                          $scope.min_r=$scope.current_price_r;

                          $scope.ville_origin_r=$scope.city_origin_r;
                          
                          $scope.ville_destination_r=$scope.city_destination_r;
                         
                          $scope.heure_origin_r=$scope.time_departure_r;
                          
                          $scope.heure_destination_r=$scope.time_arrival_r;
                          
                        }
                       
                    }
                    if($scope.priceCondition.operator_price==300 
                      && $scope.hourCondition.operator_r=='00:00'){
                         $scope.pagination_r = Pagination.getNew(4);
                    }
                    else{
                         $scope.pagination_r = $scope.trips_number_r.length;
                    }
                    $scope.pagination_r.numPages = 0
                   
                     $scope.$watch(
                      function () {
                         return $scope.pagination_r.numPages = Math.ceil($scope.trips_number_r.length / $scope.pagination_r.perPage);
                                  
                                  },
                      function () {
                            $scope.trips_number_r != null;
                            
                                  }
                                 );
                })
                }
              })
              
          });
        

        
     }
     
     $scope.calculateDuration = function(a,b){
         return ComputeDuration.calculer_duree(a,b);
     }

     $scope.customStyle = {};
     $scope.displayRestrictions = function(a){
          if(a==='RefWithCondition')
          	{
               $scope.customStyle.style = {"color":"orange"};
               a="Billet modifiable sous conditions";
            }
          if(a==='Refundable')
          	{
               $scope.customStyle.style = {"color":"green"};
               a="Billet modifiable";
           }
            if(a==='Exchangeable')
            {
               $scope.customStyle.style = {"color":"green"};
               a="Billet échangeable";
           }
          
           if(a==='NotExchNotRef')
            {
               $scope.customStyle.style = {"color":"red"};
               a="Billet non échangeable et non modifiable";
           }
          return a;
     }
     $scope.displayClass = function(a){
     	if(a==='SECOND_CLASS_SEAT')
     	{
     		a="2ème Classe";
     	}
     	if(a==='FIRST_CLASS_SEAT')
     	{
     		a="1ère Classe";
     	}
     	return a;
     }
     $scope.displayDay = function(a){
     	var fields_a = a.split('-');
        var temp = fields_a[2];
        fields_a[2]=fields_a[0];
        fields_a[0]=temp;
        var z = fields_a.join('-');
        return z

     }; 
   
       
     
     $scope.b=[];
     for (i = 0; i < 26; i++){
        $scope.b[i]={ state: false,
           text: "Sélectionner"}

     }
     
     $scope.select_journey_one_way = function(c,a){
      
        $scope.b[c].state = !$scope.b[c].state;
        $scope.b[c].text = $scope.b[c].state ? 'Désélectionner' : 'Sélectionner';
         console.log($scope.b[c].state)
           console.log($scope.b[c].text)
        if ($scope.b[c].text=="Sélectionner")
        {
           BookingInformation.one_way={};
           
           console.log(BookingInformation.one_way)
        }else{
           BookingInformation.one_way=a;
   
           console.log(BookingInformation.one_way)
        }
      
      /*$location.path("/journey")*/

      /*$state.go('journey');*/
      
      };
     $scope.select_journey_return = function(b){
      BookingInformation.return=b;
      /*$location.path("/journey")*/
      console.log(b)
      /*$state.go('journey');*/
      
     }
    $scope.validate_journey=function(){
      if($scope.type_trip=='Aller-retour' && !angular.equals({},BookingInformation.one_way) && !angular.equals({},BookingInformation.return)){  
               console.log($scope.type_trip)
               console.log(BookingInformation.one_way)
               console.log(BookingInformation.return)
               $location.path("/journey")
               
        }else if($scope.type_trip=='Aller simple' && !angular.equals({},BookingInformation.one_way)){   
            console.log($scope.type_trip)
            console.log(BookingInformation.one_way)
            BookingInformation.return={};
            $location.path("/journey")
        }
        else{
          console.log($scope.type_trip)
           console.log(BookingInformation.one_way)
           console.log(BookingInformation.return)
          console.log("je reste sur train")
          $location.path("/train")
        }
         
    }
     $scope.hoverIn = function(){
        this.hoverEdit = true;
    }
    

    $scope.hoverOut = function(){
        this.hoverEdit = false;
    };
        
     
     
}]);

