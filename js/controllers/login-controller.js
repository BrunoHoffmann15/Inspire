app.controller('loginCtrl', function($scope, usuarioService, $localStorage){
    $scope.usuario = {}
    $scope.logar = function(){
        debugger;
        usuarioService.buscarPorLogin($scope.usuario).then(function (response){
            if(response.data[0].email != undefined){
                if(response.data[0].senha == $scope.usuario.senha){
                    $scope.usuario = response.data[0];
                    $localStorage.usuario = $scope.usuario;
                }else{
                    alert("senha errada");
                }
            }else{
                alert("usuário não encontrado");
            }
        });
    }

});