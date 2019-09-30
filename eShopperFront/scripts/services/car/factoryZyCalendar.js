/**
 * Created by yzaghir on 23/06/2016.
 */

angular.module("eShopperApp").factory("zyCalendarService" , function () {

  var zyDate = {
    dtInit : new Date(),
    dtTemp : new Date(),
    annee : null,
    mois : null,
    moisNom :null ,
    jours :[] ,
    datePret :null,
    heurePret : null,
    dateRetour :null ,
    heureRetour :null ,
    choixDt :null,
    viewCalendrier : false,
    heures:[
      {   id: 8  , value: "8H", activedCss:"" , actived:true },
      {   id: 9  , value: "9H", activedCss:"" , actived:true },
      {   id: 10 , value:"10H", activedCss:"" , actived:true },
      {   id: 11 , value:"11H", activedCss:"" , actived:true },
      {   id: 12 , value:"12H", activedCss:"" , actived:true },
      {   id: 13 , value:"13H", activedCss:"" , actived:true },
      {   id: 14 , value:"14H", activedCss:"" , actived:true },
      {   id: 15 , value:"15H", activedCss:"" , actived:true },
      {   id: 16 , value:"16H", activedCss:"" , actived:true },
      {   id: 17 , value:"17H", activedCss:"" , actived:true },
      {   id: 18 , value:"18H", activedCss:"" , actived:true }
    ],
    init : function(){
      //console.log("init----");
      zyDate.annee = zyDate.dtInit.getFullYear();
      zyDate.mois = zyDate.dtInit.getMonth() ;
      zyDate.moisNom = zyDate.getNomMois(zyDate.dtInit.getMonth() );
      zyDate.jours = zyDate.getTableJours(zyDate.mois , zyDate.annee);
    },
    plusMois :function(){
      if(zyDate.mois < 11){
        zyDate.mois++ ;
        zyDate.moisNom = zyDate.getNomMois(zyDate.mois ) ;
      }else{
        zyDate.mois = 0 ;
        zyDate.moisNom = zyDate.getNomMois(zyDate.mois ) ;
        zyDate.dtTemp.setFullYear(zyDate.dtTemp.getFullYear() + 1) ;
        zyDate.annee =  zyDate.dtTemp.getFullYear() ;
      }
      zyDate.jours = zyDate.getTableJours(zyDate.mois , zyDate.annee);
    },
    moinsMois:function(){
      if(zyDate.mois>=1){
        zyDate.mois-- ;
        zyDate.moisNom = zyDate.getNomMois(zyDate.mois) ;
      }else{
        if(zyDate.dtTemp.setFullYear()> zyDate.dtInit.setFullYear()){
          zyDate.dtTemp.setFullYear(zyDate.dtTemp.getFullYear() - 1)
          zyDate.annee =  zyDate.dtTemp.getFullYear() ;
          zyDate.mois = zyDate.getNomMois.length-1 ;
          zyDate.moisNom = zyDate.getNomMois(zyDate.mois-1) ;
        }
      }
      zyDate.jours = zyDate.getTableJours(zyDate.mois , zyDate.annee);
    },

    dernierJourDuMois: function(iMonth, iYear)
    {
      return new Date(iYear, iMonth, 0).getDate();
    },
    dayOfTheWeek: function (iMonth, iYear) {
      var dt = new Date();
      dt.setDate(1);
      dt.setMonth(iMonth);
      dt.setFullYear(iYear);
      return dt.getDay();
    },
    getNomMois :function(mois ){
      var s = null ;
      switch(mois) {
        case 0:
          s = "Janvier";
          break;
        case 1:
          s = "Fevier";
          break;
        case 2:
          s = "Mars";
          break;
        case 3:
          s = "Avril";
          break;
        case 4:
          s = "Mai";
          break;
        case 5:
          s = "Juin";
          break;
        case 6:
          s = "Juillet";
          break;
        case 7:
          s = "Aout";
          break;
        case 8:
          s = "Septembre";
          break;
        case 9:
          s = "Octobre";
          break;
        case 10:
          s = "Novembre";
          break;
        case 11:
          s = "Decembre";
          break;
      }
      return s;
    } ,
    getTableJours : function(mois , annee){
      var jours =new Array();
      var cpt = 1 ;
      var maxJour = zyDate.dernierJourDuMois(mois , annee);
      var jourDuMois =zyDate.dayOfTheWeek(mois , annee ) ;
      var ligne1 = new Array();
      for(var j= 0 ; j<7 ;j++){       // premier iteration
        if(j<jourDuMois -1){
          ligne1.push(
            {
              id: "" ,
              value:annee +"-"+ ("0" + (mois + 1)).slice(-2) +"-" + ("0" + (cpt)).slice(-2),
              activedCss:"" ,
              actived:false
            });
        }else{
          ligne1.push(
            {
              id: cpt ,
              value:annee +"-"+ ("0" + (mois + 1)).slice(-2) +"-" + ("0" + (cpt)).slice(-2),
              activedCss:"" ,
              actived:true
            });
          cpt++;
        }
      }
      jours.push(ligne1);

      for(var i = 1 ; i<6 ; i++){   // continue l'iteration des 6 lignes
        var jr = new Array();
        for(var j = 0 ; j<7 ; j++){
          if(cpt<= maxJour){
            jr.push(
              {
                id: cpt ,
                value:annee +"-"+ ("0" + (mois + 1)).slice(-2) +"-" + ("0" + (cpt)).slice(-2),
                activedCss:"" ,
                actived:true});
          }
          cpt++;
        }
        jours.push(jr);
      }
      return jours ;
    } ,
    getJourForm:function(j){
      zyDate.jours.forEach(function (elementLigne) {
        elementLigne.forEach(function(elementJour){
          if(elementJour.id == j.id){
            elementJour.activedCss = "active";
          } else{
            elementJour.activedCss = "";
          }

        });
      });
      if(zyDate.choixDt =="pret"){
        zyDate.datePret = j ;
      }else if(zyDate.choixDt =="retour"){
        zyDate.dateRetour = j ;
      }
    },
    getHeureForm:function(h){
      zyDate.heures.forEach(function (elementHeure) {
        if(elementHeure.id == h.id){
          elementHeure.activedCss = "active";
        } else{
          elementHeure.activedCss = "";
        }

      });
      if(zyDate.choixDt =="pret"){
        zyDate.heurePret = h ;
      }else if(zyDate.choixDt =="retour"){
        zyDate.heureRetour = h ;
      }
    },
    diffdate : function(d1,d2,u){
      var div=1;
      switch(u){
        case 's':
          div=1000;
          break;
        case 'm':
          div=1000*60;
          break;
        case 'h':
          div=1000*60*60;
          break;
        case 'd':
          div=1000*60*60*24;
          break;
      }

      var Diff = d2.getTime() - d1.getTime();
      return Math.ceil(Diff/div) + 1;
    }
    /*afficherCalendier:function (ch) {
     recherche.pourcentage = 1 ;
     if(zyDate.viewCalendrier == false){
     zyDate.viewCalendrier = true ;
     ctrl.categorie.viewCategorie = false ;
     }
     console.log("--------------"+ch);
     zyDate.choixDt = ch ;

     }*/
  };
  return zyDate ;

});
