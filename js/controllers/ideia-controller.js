app.controler('ideiaCtrl', function($scope, ideiaService, $routeParams) {
  $scope.ideia = {};

  ideiaService.buscarPorId($routeParams.id).then(r => $scope.ideia = r.data);

});
