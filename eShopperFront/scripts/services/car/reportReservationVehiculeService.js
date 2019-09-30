/**
 * Created by yzaghir on 24/06/2016.
 */
angular.module("eShopperApp")
  .factory("reportReservationVehiculeService" ,['$resource' , '$q','$http' , "CConfigCar" ,"zyCalendarService" ,
    function($resource , $q ,$http , CConfigCar ,zyCalendarService ){

      var service ={
        urlRest :CConfigCar.reservation.url ,
        donnees: [],
        getReservation: getReservation,
        getReport : getReport
      };
      return service ;

      function getReservation(element){
        var def  = $q.defer();
        $http({
          method:"POST",
          url :service.urlRest+"/report",
          headers :{"Content-type" : "application/json"} ,
          data:element,
          params:element
        }).success(function(data){
          def.resolve(data);
          service.getReport(data)

        }).error(function(data){
          def.reject("Failed to get data");
        }) ;
        return def.promise ;
      };
      
      function getReport(objRes){

        console.log(objRes);

        var x = 0 ;
        var y = 0 ;
        var maxWidthConvention = 180 ;
        /*var name = prompt('What is your name?');
         var multiplier = prompt('Enter a number:');
         multiplier = parseInt(multiplier);*/

        var doc = new jsPDF();

        doc.setFont("arial");
        // Black square with rounded corners
        x = 20 ;
        doc.setDrawColor(0);
        doc.setFillColor(5, 77, 132);
        doc.rect(x, 20, maxWidthConvention, 10 ,"FD");

        doc.setFontSize(20);
        doc.setFontType("bold");
        doc.setTextColor(250);
        doc.text(x+20, 27, 'Contrat de location de véhicule ');
        doc.rect(x , 20 , maxWidthConvention , 50) ;
        doc.line(x+maxWidthConvention/2, 30, x+maxWidthConvention/2, 70);

        x =25 ; y = 40; //-------------------------------------Info Agence------------------------------
        doc.setFontSize(16);
        doc.setFontType("normal");
        doc.setTextColor(0);
        doc.text(x, y, objRes.vehicule.agence.nom);

        y += 7;
        doc.setFontSize(12);
        doc.text(x, y,  objRes.vehicule.agence.adresse);

        y += 7;
        doc.setFontSize(12);
        doc.text(x , y,  objRes.vehicule.agence.ville);
        y += 7;
        doc.setFontSize(12);
        doc.text(x , y,  objRes.vehicule.agence.pays );

        x = 25 + maxWidthConvention/2 ; //-------------------------------------Info Client------------------------------
        y = 40;

        doc.setFontSize(10);
        doc.setTextColor(0);
        doc.text(x, y, 'Nom : '+ objRes.client.nom);
        y += 5;
        doc.text(x, y, 'Prénom : '+ objRes.client.prenom);
        y += 5;
        doc.text(x, y, 'Adresse : '+ objRes.client.adresse);
        y += 5;
        doc.text(x, y, '          '+objRes.client.ville+" "+objRes.client.codePostal +" " +objRes.client.pays);
        y += 5;
        doc.text(x, y, 'Tél.: '+objRes.client.telephone );
        y += 5;
        doc.text(x, y, 'Email.: '+ objRes.client.email);


        x = 20 ;y = 100 ;     //-------------------------------Convention de location  -------------------------
        doc.setDrawColor(0);
        doc.setFillColor(5, 77, 132);
        doc.rect(x, y, maxWidthConvention, 10 ,"FD");
        doc.setFontSize(20);
        doc.setFontType("bold");
        doc.setTextColor(250);
        doc.text(x+ 40, y+7, 'Convention de location ');
        doc.setDrawColor(0);
        doc.rect(x, y, maxWidthConvention, 90);
        doc.line(maxWidthConvention/3 +15 , y+30 ,maxWidthConvention/3 +15 , 190 )


        x = 20 , y += 10;
        doc.setFontSize(10);
        doc.setFontType("normal");
        doc.setTextColor(0);
        doc.text(x+10, y+7, 'Véhicule demandé :' +objRes.vehicule.nom );

        x = 20 , y += 10;
        var dt = new Date(objRes.datePret) ;
        doc.text(x+10, y+7 , 'A partir du : '+dt.getFullYear()+"-"+ (("0"+dt.getMonth()).slice(-2)) + "-" + (("0"+dt.getDate()).slice(-2)) + " A : "+objRes.heurePret.substr(0,5));
        dt = new Date(objRes.dateRetour) ;
        doc.text(x+90, y+7 , 'Au : '+dt.getFullYear()+"-"+ (("0"+dt.getMonth()).slice(-2)) + "-" + (("0"+dt.getDate()).slice(-2)) +  " A : "+objRes.heureRetour.substr(0,5));
        //doc.text(x+120, y+7, 'Durée :  xxx j ');

        doc.line(x, y, maxWidthConvention+20, y);

        x = 20 , y += 10;
        doc.text(x+10, y+7 , 'Propriété du véhicule ');
        doc.line(x, y, maxWidthConvention+20, y);

        x = 20 , y += 10;
        doc.text(x+60, y+7 , 'Catégorie : '+objRes.vehicule.acrissCarCode1.categorie);
        doc.text(x+120, y+7 , 'Type : '+objRes.vehicule.acrissCarCode2.typeVehicule);
        doc.line(x, y, maxWidthConvention+20, y);

        x = 20 , y += 10;
        doc.text(x+60, y+7, 'Drive : '+objRes.vehicule.acrissCarCode3.drive);
        doc.text(x+120, y+7 , 'Transmission : '+objRes.vehicule.acrissCarCode3.transmission);
        doc.line(maxWidthConvention/3 +15, y, maxWidthConvention+20, y);

        x = 20 , y += 10;
        doc.text(x+60, y+7 , 'Climatisation  : '+objRes.vehicule.acrissCarCode4.airCondition);
        doc.text(x+120, y+7, 'Moteur : '+objRes.vehicule.acrissCarCode4.fuel);
        doc.line(maxWidthConvention/3 +15, y, maxWidthConvention+20, y);

        x = 20 , y += 10;
        doc.text(x+60, y+7 , 'Numéro Immatriculation : '+objRes.vehicule.immatriculation);
        doc.line(maxWidthConvention/3 +15, y, maxWidthConvention+20, y);

        x = 20 , y += 10;
        doc.text(x+60, y+7 , 'Reservation : '+objRes.codeReservation);
        doc.line(maxWidthConvention/3 +15, y, maxWidthConvention+20, y);

        x = 20 ; y = 200 ;     //------------------------------- Facture Montant  -------------------------
        doc.setDrawColor(0);
        doc.setFillColor(5, 77, 132);
        doc.rect(x, y, maxWidthConvention/2, 10 ,"FD");
        doc.setFontSize(14);
        doc.setFontType("bold");
        doc.setTextColor(250);
        doc.text(x+10, y+7, 'Facture ');
        doc.setDrawColor(0);
        doc.rect(x, y, maxWidthConvention/2, 40);

        doc.setFontSize(12);
        doc.setTextColor(0);
        doc.setFontType("normal");

        x = 20 ; y = 220;
        doc.text(x+5, y , 'Prix Par Jour : ');
        doc.text(maxWidthConvention/2 -5 ,y , ""+objRes.prix);
        doc.line(x, y+2, maxWidthConvention/2 +20, y+2);
        y += 7;
        doc.text(x+5, y, 'Nb. Jours : ');
        var nbJour = +zyCalendarService.diffdate(new Date(objRes.datePret) , new Date(objRes.dateRetour) , 'd')
        doc.text(maxWidthConvention/2 -5 ,y , ""+nbJour);
        doc.line(x, y+2, maxWidthConvention/2 +20, y+2);
        y += 7;
        doc.text(x+5, y, 'Total de prestation ');
        doc.text(maxWidthConvention/2 -5 ,y , ""+nbJour*objRes.prix);
        doc.line(x, y+2, maxWidthConvention/2 +20, y+2);

        y = 210;
        doc.line(80, y, 80 , y+30);



        //var string = doc.output('datauristring');
        doc.output('dataurlnewwindow', {});
        /*var iframe = "<iframe width='100%' height='100%' src='" + string + "'></iframe>"

         var x = window.open();
         x.document.open();
         x.document.write(iframe);
         x.document.close();
         doc.save('ReservationVehicule.pdf');*/


      }

    }]) ;
