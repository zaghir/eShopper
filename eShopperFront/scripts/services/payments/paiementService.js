angular.module("eShopperApp").factory(
		"paiementService",
		[ '$resource', '$q', '$http', "CConfigCar",
				function($resource, $q, $http, CConfigCar) {

					var service = {
						pay : {
							PSPID : null,
							ORDERID : null,
							AMOUNT : null,
							CURRENCY : null,
							LANGUAGE : null,
							CN : null,
							EMAIL : null,
							OWNERZIP : null,
							OWNERADDRESS : null,
							OWNERCTY : null,
							OWNERTOWN : null,
							OWNERTELNO : null,
							SHASIGN : null,
							TITLE : null,
							BGCOLOR : null,
							TXTCOLOR : null,
							TBLBGCOLOR : null,
							TBLTXTCOLOR : null,
							BUTTONBGCOLOR : null,
							BUTTONTXTCOLOR : null,
							LOGO : null,
							FONTTYPE : null,
							ACCEPTURL : null,
							DECLINEURL : null,
							EXCEPTIONURL : null,
							CANCELURL : null
						} ,
						genereCode : genereCode ,
						sendPaiement :sendPaiement ,
						getField : getField

					};
					
					return service;					
					
					function sendPaiement(value){
						
						var chaineFormated = service.getField(value) ;
						var chaineSha = service.genereCode(chaineFormated);
						
						$http({
					        method:"POST",
					        url :"https://secure.ogone.com/ncol/test/orderstandard.asp",
					        headers : {"Content-type" : "application/json"} ,
					        data : obj ,
					        params : obj
					      })
					        .success(function(data) {
					          def.resolve(data);
					        })
					        .error(function(data) {
					          def.reject("Failed to get data");
					        });
					      return def.promise;
					};
					
					function getField(pay){
						var t = [];                             // t tableau
						var f;               		 			// f field
						var c = "";					 			// c chain
						var k = "Mysecretsig1875!?"; 			// k key
							
						for(f in pay){
							if((pay[f] !== undefined) && (pay[f] !== null)  ){
								t.push(f);							//tableau peuplé des données du formulaire
							}
							
						};			
						t.sort();                           // Champs du tableau ordonnés par ordre alphabétique
						
						t.forEach(function(f){
							c += f + "=" + pay[f] + k; //construction de la chaine à crypter														
						});
																		
						return c; //chaine cryptée
					};
					
					function genereCode(value){
						var str = CryptoJS.SHA1(value).toString().toUpperCase();
						return str;
					};
					

				} ]);