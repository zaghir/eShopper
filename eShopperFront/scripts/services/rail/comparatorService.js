app.service('Comparator',function(){
	this.comparer_prix=function(a,b){
              var x =false;
              var c = parseFloat(a);
              var d = parseInt(b);
              if (c >= d){
                 x=true;
               }
              return x;
            }
    this.comparer_nombres=function(a,b){
              
              var n = a.localeCompare(b);
              if(n===1){
                n=true;
              }
              else{
                n=false;
              }
            
              return n

       }
	
})