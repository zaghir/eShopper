app.controller('reservationVolCtrl', ['$scope', 'reservationVol', 'client', 'voyageur', 'api',
    function ($scope, reservationVol, client, voyageur, api) {

        $scope.reservationresult = ''
        $scope.reservationresult = reservationVol.resultVol;
        $scope.voyageurs = [{
                trancheAge: null,
                nom: null,
                prenom: null
            }];

        //persister une reservation
        $scope.saveReservation = function () {
            //passer ici les données récupérées de la vue avec le scope pour qu'elles soit persistées grace aux methodes de la factory
            client.getClient(api.apiClient).save($scope.client);
            voyageur.getVoyageur(api.apiVoyageur).save($scope.voyageur)
        }
        //rajouter un voyageur
        $scope.ajouterVoyageur = function () {
            console.log("Ajouter");
            $scope.voyageurs.push({
                trancheAge: null,
                nom: null,
                prenom: null
            });
        }
        //Supprimer un voyageur
        $scope.suprimerVoyageur = function () {
            console.log("Supprimer");
            $scope.voyageurs.pop();
        }

    }]);
 