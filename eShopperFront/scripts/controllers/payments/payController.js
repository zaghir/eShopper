app.controller('payCtrl', ['$scope','$location' , 'paiementService',
		function($scope , $location , paiementService){
			var ctrl = this ;
			$scope.pay= {} ;

			/*
			paiementService.pay.PSPID          = "eshopperpay" ;              données pour les tests
			paiementService.pay.ORDERID        = "AA123456789" ;			  Pour cette version de test sur ogone
			paiementService.pay.LANGUAGE       = "fr_FR";					  il faut utilisé la langue francaise les autres langues ne sont pas accepté
			paiementService.pay.CURRENCY       = "EUR";						  il faut parametré ogone pour qu'il accepte la transaction avec no 
			paiementService.pay.AMOUNT         = 120.25 *100 ;				  dans le menu admin ogone onglet --> Configuration			
			paiementService.pay.CN             = "Amin";															--> Technical information
			paiementService.pay.EMAIL          = "amin.ali@gmail.com";													-->Data and origin verification
			paiementService.pay.OWNERADDRESS   = "15 ,  rue Hicham";														--> Checks for e-Commerce
			paiementService.pay.OWNERZIP       = "20300";																		saisir l'url exp:
			paiementService.pay.OWNERTOWN      = "Rabat";																		 http://localhost:8080/;	
			paiementService.pay.OWNERCTY       = "FRANCE";																pour le numero de carte il faut voir le site de ogone 
			paiementService.pay.OWNERTELNO     = "0122334455";*/														//et utilisé un carte pre-defini (dans la rubrique test info ) exp : 
			
			
			/* les données de la reservations sont recupées à travers l'url et le service $locationn de angular
			  l'utilisation de ce module de paiement ce fait par un petit mapping entre l'objet pay defini dans le service
			  et le l'objet reservation porteur d'information 
			  le reste est inchangeable 
			*/
			var res = $location.search();
			//-------------------------------------------------------------------------------Start Mapping-------------
			console.log(res);
			paiementService.pay.PSPID         = "eshopperpay" ;
			paiementService.pay.ORDERID        = res.reservation.codeReservation  ;
			paiementService.pay.CURRENCY       = "EUR";
			paiementService.pay.AMOUNT         = res.reservation.prix *100 ;
			paiementService.pay.LANGUAGE       = "fr_FR";
			paiementService.pay.CN             =  res.reservation.client.nom+" "+res.reservation.client.prenom;
			paiementService.pay.EMAIL          =  res.reservation.client.email;
			paiementService.pay.OWNERADDRESS   =  res.reservation.client.adresse;
			paiementService.pay.OWNERZIP       =  res.reservation.client.codePostal;
			paiementService.pay.OWNERTOWN      =  res.reservation.client.ville;
			paiementService.pay.OWNERCTY       =  res.reservation.client.pays;
			paiementService.pay.OWNERTELNO     =  res.reservation.client.telephone;
			//-------------------------------------------------------------------------------End Mapping---------------

			var listchamps = paiementService.getField(paiementService.pay);
			console.log(listchamps) ;

			paiementService.pay.SHASIGN = paiementService.genereCode(listchamps) ;
			console.log(paiementService.pay);

			$scope.pay = paiementService.pay ;

			


		}]);