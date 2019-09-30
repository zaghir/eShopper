app.service('ComputeDuration',function(){
	this.calculer_duree=function(a,b){
        
     	var fields_a = a.split(':');
     	
     	var fields_b = b.split(':');
     	
        var u = (parseInt(fields_a[0])*60)+parseInt(fields_a[1]);
        
     	var v= (parseInt(fields_b[0])*60)+parseInt(fields_b[1]);
       
     	var x = (v-u)/60;
     	var y = Math.floor(((x%1).toFixed(2))*60);
        var z = Math.floor(x);
        if(z<0 && y<0)
        {
            z=z+24;
            y=y+60;
        }
        if (y.toString().length==1){
           y= ("0" + y).slice(-2);
        }
     	 res=z+"h"+y;
     	
     	return res;
     }
	
})