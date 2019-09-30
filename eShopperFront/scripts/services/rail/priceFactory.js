app.factory('PriceFinder', function () {

  var service={
       prices : [{value: '300',displayName: '300 €'}, { value: '250',displayName: '250 €'}, 
       {value: '200',displayName: '200 €'},{value: '150',displayName: '150 €'},{value: '140',displayName: '140 €'},
       {value: '130',displayName: '130 €'},{value: '120',displayName: '120 €'},{value: '110',displayName: '110 €'},
       {value: '100',displayName: '100 €'},{value: '90',displayName: '90 €'},{value: '80',displayName: '80 €'},
       {value: '70',displayName: '70 €'},{value: '60',displayName: '60 €'},{value: '50',displayName: '50 €'},
       {value: '40',displayName: '40 €'},{value: '30',displayName: '30 €'},{value: '20',displayName: '20 €'},
       {value: '10',displayName: '10 €'}],

       priceCondition : {
         operator_price: '300'
        }
  }
  return service
 
});