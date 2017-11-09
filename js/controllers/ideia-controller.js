app.controller('ideiaCtrl', function($scope, ideiaService){
    $scope.ideias = {};
    ideiaService.listar().then( r => {
        $scope.ideias = r.data;
    });

});
