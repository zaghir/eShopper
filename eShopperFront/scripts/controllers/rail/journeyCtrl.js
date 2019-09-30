app.controller('journeyCtrl', function($scope,BookingInformation) {
   $scope.receivedDataA=BookingInformation.one_way;
   $scope.receivedDataR=BookingInformation.return;
   $scope.sendBooking=function(bookingDetails){
       
		   	   $scope.reservation = angular.copy(bookingDetails);
		   	   console.log("reservation : "+ $scope.reservation.insurance);
		   	   
       
   }
   
    /*var str=JSON.stringify($scope.receivedData)
		            
	console.log(str)	*/      
		            
             
    $scope.displayDay = function(a){
     	var fields_a = a.split('-');
        var temp = fields_a[2];
        fields_a[2]=fields_a[0];
        fields_a[0]=temp;
        var z = fields_a.join('-');
        return z

     };
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
  
   	   

       
});