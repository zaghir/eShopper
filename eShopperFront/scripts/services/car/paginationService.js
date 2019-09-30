/**
 * Created by yzaghir on 28/06/2016.
 */

angular.module("eShopperApp")
    .factory("paginationService" , [function () {

        var service = {
            getPagination :getPagination,
            getOnePage : getOnePage
        }
        return service ;

        function getPagination(data , resultatParPage){
            var table ={};
            table.pageIndex = [];
            table.pages=[];
            table.page =[];
            var nbElementParPage = resultatParPage ;
            for(var i = 1 ; i <= (Math.floor(-data.length/nbElementParPage)*-1) ; i++){
                table.pageIndex.push(i);
                console.log(i);
            }
            var cpt = 0 ;
            for(var  i = 0 ; i < table.pageIndex.length ; i++ ){
                var ligne = [] ;
                for(j= 1 ; j<= nbElementParPage ;j++ ){
                    if(cpt< data.length){
                        ligne.push({
                            idPage:i+1,
                            element : data[cpt]
                        })
                    }
                    cpt++ ;
                }
                table.pages.push(ligne);
            }
            table.page = table.pages[0];

            return table ;
        }

        function getOnePage(data , indexPage){
            data.pages.forEach(function(element , index){
                if(index == (indexPage - 1)){   // en commence pas 0 et dans l'affichage en commence par 1
                   console.log( index+"  "+indexPage);
                    data.page = element;
                }
            });
            return data;
        }

    }]);
