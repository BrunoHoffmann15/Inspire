app.controller('feedCtrl', function ($scope, loginService, $location, ideiaService, categoriaService) {

    if (loginService.usuarioLogado() == undefined) {
        $location.path("/login");
    } else {
        $scope.ideias = [];
        $scope.categorias = [];

        categoriaService.listar().then(r => {
            $scope.categorias = r.data;
            $scope.categorias.push({id:0, nome:"Todas"});
        });
        ideiaService.listar().then(r => {
            $scope.ideias = r.data;
            $scope.todasIdeias = $scope.ideias;
        });
        $scope.filter = function (filtro) {
            $scope.ideias = $scope.todasIdeias;
            if(filtro.id !== 0){
                $scope.ideias = $scope.ideias.filter(x => x.categoria.id == filtro.id);
            }
        }
        var ideia;
      $scope.curtir = function(id) {
          ideiaService.buscarPorId(id).then(function(r){
            // ideia = r.data
            ideia = r.data;
            console.log(ideia.curtidas);
            ideia.curtidas = ideia.curtidas + 1;
            console.log(ideia.curtidas);
            ideiaService.alterar(ideia);
            // ideia.curtidas = ideia.curtidas + 1;
            // ideiaService.alterar($scope.ideia);
          });

        }

    }
});
