angular.module('app').controller('UserController', function($http, $scope, userService, $localStorage, $routeParams, authService) {
  $scope.user ={};
  $scope.registrar = registrar;
  $scope.logout = authService.logout;


  // $scope.atualizar = atualizar;
  // $scope.isAlterar = !!$routeParams.idUser;
  userService.get().then(r => $scope.usuarioLogado = r.data);
  console.log($scope.usuarioLogado);
  function registrar() {
    console.log($scope.user);
    userService.post($scope.user).then(function(res){
      alert('ok');
    });
    }



// function atualizar() {
//   $scope.user.id = $routeParams.idUser;
//   userService.put($scope.user).then(resp => alert('ok'));
// }

  userService.getAlbuns().then(r => $scope.albuns = r.data);
});
