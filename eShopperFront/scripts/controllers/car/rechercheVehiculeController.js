/**
 * Created by yzaghir on 05/07/2016.
 */
angular.module("eShopperApp").controller("rechercheVehiculeController" , ["$state" ,"acrissCarCode1Service",
  "acrissCarCode2Service" , "acrissCarCode3Service" ,"acrissCarCode4Service", "zyCalendarService" ,"vehiculeService" ,
  "$window", "$location","$timeout",
  function($state ,acrissCarCode1Service ,acrissCarCode2Service , acrissCarCode3Service ,acrissCarCode4Service ,
           zyCalendarService ,vehiculeService , $window , $location , $timeout){

    var ctrl = this;

    ctrl.zyDate = zyCalendarService;
    ctrl.zyDate.init();
    ctrl.vehicule = {};


    ctrl.afficherCalendier = function (ch) {
      ctrl.recherche.pourcentage = 1 ;
      ctrl.recherche.pourcentage = 1 ;
      ctrl.afficheLeCritere("calendrier");
      ctrl.zyDate.choixDt = ch ;

    };

    ctrl.afficheLeCritere = function(nom){
      ctrl.recherche.pourcentage = 1 ;

      switch (nom){
        case "categorie":
          ctrl.categorie.viewCategorie = true ;
          ctrl.type.viewType = false ;
          ctrl.zyDate.viewCalendrier = false ;
          ctrl.transmissionDrive.viewTransmissionDrive = false ;
          ctrl.recherche.viewResultat = false ;
          break;
        case "type" :
          ctrl.categorie.viewCategorie = false ;
          ctrl.type.viewType = true ;
          ctrl.zyDate.viewCalendrier = false ;
          ctrl.transmissionDrive.viewTransmissionDrive = false ;
          ctrl.recherche.viewResultat = false ;
          break;
        case "transmission" :
          ctrl.categorie.viewCategorie = false ;
          ctrl.type.viewType = false ;
          ctrl.zyDate.viewCalendrier = false ;
          ctrl.transmissionDrive.viewTransmissionDrive = true ;
          ctrl.recherche.viewResultat = false ;
          break;
        case "calendrier" :
          ctrl.categorie.viewCategorie = false ;
          ctrl.type.viewType = false ;
          ctrl.zyDate.viewCalendrier = true ;
          ctrl.transmissionDrive.viewTransmissionDrive = false ;
          ctrl.recherche.viewResultat = false ;
          break;
        case "resultatRecherche" :
          ctrl.categorie.viewCategorie = false ;
          ctrl.type.viewType = false ;
          ctrl.zyDate.viewCalendrier = false ;
          ctrl.transmissionDrive.viewTransmissionDrive = false ;
          ctrl.recherche.viewResultat = true ;
          break;
      };
    };

    ctrl.categorie = {
      listCategories : [] ,
      categorieSelected : null ,
      viewCategorie :false,
      afficheCategorie : function () {
        ctrl.afficheLeCritere("categorie");
      },
      choixCategorie : function(c){
        ctrl.categorie.listCategories.forEach(function(element){
          if(element.code == c.code){
            element.activedCss = "active" ;
            ctrl.categorie.categorieSelected = element ;
          } else{
            element.activedCss = "" ;
          }
        });
      }
    };

    ctrl.type ={
      listTypes :[] ,
      typeSelected : null,
      viewType :false ,
      afficheType :function(){
        ctrl.afficheLeCritere("type");
      },
      choixType : function(c) {
        ctrl.type.listTypes.forEach(function(element){
          if(element.code == c.code){
            element.activedCss = "active" ;
            ctrl.type.typeSelected = element ;
          }else{
            element.activedCss = "";
          }
        });
      }
    };

    ctrl.transmissionDrive ={
      listTransmissionDrives :[] ,
      transmissionDriveSelected : null,
      viewTransmissionDrive :false ,
      afficheTransmissionDrive :function(){
        ctrl.afficheLeCritere("transmission");
      },
      choixTransmissionDrive : function(c) {
        ctrl.transmissionDrive.listTransmissionDrives.forEach(function(element){
          if(element.code == c.code){
            element.activedCss = "active" ;
            ctrl.transmissionDrive.transmissionDriveSelected = element ;

          }else{
            element.activedCss = "";
          }
        });
      }
    };

    ctrl.recherche = {
      tableData : [],
      pourcentage : 1,
      viewResultat :false ,
      totalPrix : 0,
      find :function(path){
        //$window.location.href="http://www.google.fr";
        ctrl.messageError ={};
        ctrl.messageError.cpt = 0 ;        
        if(ctrl.zyDate.datePret == undefined ){
          ctrl.messageError.datePret = true ;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.datePret = false ;
        }
        if(ctrl.zyDate.heurePret == undefined){
          ctrl.messageError.heurePret = true ;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.heurePret = false ;
        }
        if(ctrl.zyDate.dateRetour == undefined){
          ctrl.messageError.dateRetour = true ;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.dateRetour = false ;
        }
        if(ctrl.zyDate.heurePret == undefined){
          ctrl.messageError.heurePret = true ;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.heurePret = false ;
        }
        if((new Date(ctrl.zyDate.datePret.value)) >= (new Date(ctrl.zyDate.dateRetour.value))){
        	ctrl.messageError.dateRetour = true ;
        	ctrl.messageError.datePret = true ;
        	ctrl.messageError.cpt++ ;
        }
                
        if(ctrl.categorie.categorieSelected == undefined){
          ctrl.messageError.categorieSelected = true ;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.categorieSelected = false ;
        }
        if(ctrl.type.typeSelected ==  undefined){
          ctrl.messageError.typeSelected = true ;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.typeSelected = false ;
        }
        if(ctrl.transmissionDrive.transmissionDriveSelected == undefined){
          ctrl.messageError.transmissionDriveSelected = true;
          ctrl.messageError.cpt++ ;
        }else{
          ctrl.messageError.transmissionDriveSelected = false;
        }
        if(ctrl.messageError.cpt<=0){
          ctrl.recherche.pourcentage = Math.floor((Math.random() * 100) + 1) ;
          var paraSearch  = {
            datePret : ctrl.zyDate.datePret.value ,
            heurePret : ctrl.zyDate.heurePret.id ,
            dateRetour : ctrl.zyDate.dateRetour.value ,
            heureRetour : ctrl.zyDate.heurePret.id ,
            categorie: ctrl.categorie.categorieSelected.code ,
            typeVehicule : ctrl.type.typeSelected.code ,
            transmissionDrive :ctrl.transmissionDrive.transmissionDriveSelected.code
          };
          $timeout(function () {
            vehiculeService.rechercheVehicule(paraSearch).then(function(data){
              console.log(data);
              ctrl.vehicule.listVehicule = data ;
              ctrl.afficheLeCritere("resultatRecherche") ;
            });
          }, 2000);
        }

        /*rechercheVehiculeService.rechercheVehicule(null , "NCE",ctrl.zyDate.datePret.value , ctrl.zyDate.dateRetour.value ).then(function(data){
         console.log(data);
         });*/
      },
      remplirResultat : function(){
        rechercheVehiculeService.rechercheVehicule(null , "NCE","2016-06-28" , "2016-06-30" ).then(function(data){
          tableData = data.results ;
          // console.log(data.results);

        });
      } ,
      calulerPrix : function(vehicule , prixSelectionner){
        var dtPret = new Date(ctrl.zyDate.datePret.value) ;
        var dtRetour = new Date(ctrl.zyDate.dateRetour.value) ;
        var dtDiff = ctrl.zyDate.diffdate(dtPret , dtRetour ,'d') ;
        if(dtDiff > 0){
          vehicule.totalPrix ={
            prixVehicule : prixSelectionner  ,
            nombreJours : dtDiff,
            montantTotal:prixSelectionner.montant * dtDiff
          }
        }
        console.log(vehicule);
      }


    };

    ctrl.reserver = function(c) {
      console.log(c);
      $location.path("/reservationVehicule").search({
        datePret: ctrl.zyDate.datePret.value,
        heurePret: ctrl.zyDate.heurePret.id,
        dateRetour: ctrl.zyDate.dateRetour.value,
        heureRetour: ctrl.zyDate.heureRetour.id,
        vehicule: c
      });
    }

    acrissCarCode1Service.apiRest().then(function(data){
      ctrl.categorie.listCategories = data ;
    });

    acrissCarCode2Service.apiRest().then(function(data){
      ctrl.type.listTypes = data ;
    });

    acrissCarCode3Service.apiRest().then(function(data){
      ctrl.transmissionDrive.listTransmissionDrives = data ;
    });


  }]);
