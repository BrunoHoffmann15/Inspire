app.controller('loginCtrl', function($scope, usuarioService, $localStorage, $location, loginService){
    $scope.usuario = {}
    $scope.logar = function(){
        usuarioService.buscarPorLogin($scope.usuario).then(function (response){
            if(response.data[0].email != undefined){
                if(response.data[0].senha == $scope.usuario.senha){
                    $scope.usuario = response.data[0];
                    loginService.loqarUsuario($scope.usuario);
                    $location.path("/feed");
                }else{
                    alert("senha errada");
                }
            }else{
                alert("usuário não encontrado");
            }
        });   
    }
    $scope.cadastrar = function(){
        usuarioService.criarUsuario($scope.usuarioCadastro).then(function(response){
            $localStorage.usuario = response.data;
            $location.path("/feed");
        });
    }

});