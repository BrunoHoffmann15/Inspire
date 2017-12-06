app.controller('ideiaDetailCtrl', function($scope, ideiaService, categoriaService) {
  $scope.ideia = {};
  $scope.categorias = {};
  $scope.salvar = salvar;

  categoriaService.listar().then(r => $scope.categorias = r.data);

  function salvar() {
    ideiaService.adicionarideia($scope.ideia)
      .then(r => console.log(r.data))
  }
})
