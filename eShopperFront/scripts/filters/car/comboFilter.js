/**
 * Created by yzaghir on 01/07/2016.
 */
angular.module("eShopperApp").filter("comboFilter" , function(){

    return function(value){
       value = "<div class='col-md-3'>"+value+"</div>"+"<div class='col-md-3'> 123 </div>";
        console.log(value);
        return value  ;
    }
});