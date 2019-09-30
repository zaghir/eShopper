app.factory('api', function () {

var url = "http://localhost:8084/eShopperBack";


    return {
        apiAeroport: url + "/api/avion/aeroport",
        apiCompagnieAerienne:url + "/api/avion/compagnieAerienne",
        apiReservationVol: url + "/api/avion/reservation",
        apiTarif: url + "/api/avion/tarif",
        apiTerminalAero: url + "/api/avion/terminalAero",
        apiVol: url + "/api/avion/vol",
        apiVoyageur: url + "/api/avion/voyageur",
        apiClient: url + "/api/service/client"
    };
});