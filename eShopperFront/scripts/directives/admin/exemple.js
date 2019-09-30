//création d'une directive pour creer ses propre directives
//----------------------------------------
app.directive('ngMaDirective', function (){
    return {
        scope : {//on crée à chaque fois un nouveau scope (isolation) pour eviter que la directive heriter du scope parent
            exemple: '=', //ca permet de recupéré l'attribut de notre directive et de l'injecter dans le scope
            //comment: '@', //recupere la chaine de caracteres du nom de l'attribut de notre directive
            //comment: '&', //plutot pour executer une fonction par référence

        }, 
        restrict: 'E', //pour mettre une restriction pour la directive en tant qu'attribut, si non E pour element ou C pour classe
        templateUrl : 'views/admin/exemple.html' //on utilise template si on veux mettre directement le code html en tant que valeur
    };
});