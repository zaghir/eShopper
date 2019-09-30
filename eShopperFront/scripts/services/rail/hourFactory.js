app.factory('HourFinder', function () {


  var service = {
  	heures : [{value: '00:00',displayName: '00h'}, { value: '01:00',displayName: '01h'}, {value: '02:00',displayName: '02h'},
       {value: '03:00',displayName: '03h'},{value: '04:00',displayName: '04h'},{value: '05:00',displayName: '05h'},
       {value: '06:00',displayName: '06h'},{value: '07:00',displayName: '07h'},{value: '08:00',displayName: '08h'},
       {value: '09:00',displayName: '09h'},{value: '10:00',displayName: '10h'},{ value: '11:00',displayName: '11h'},
       {value: '12:00',displayName: '12h'},{value: '13:00',displayName: '13h'},{ value: '14:00',displayName: '14h'},
       {value: '15:00',displayName: '15h'},{value: '16:00',displayName: '16h'},{ value: '17:00',displayName: '17h'},
       {value: '18:00',displayName: '18h'},{value: '19:00',displayName: '19h'},{ value: '20:00',displayName: '20h'},
       {value: '21:00',displayName: '21h'},{value: '22:00',displayName: '22h'},{ value: '23:00',displayName: '23h'}
       ],
    heureCondition : {
          operator_a: '00:00',
          operator_r:'00:00'
        }
  }	

   return service ;
});
