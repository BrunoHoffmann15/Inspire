angular.module('app').controller('FriendshipController', function($scope, friendshipService, authService, userService){
  $scope.friendship = {};
  $scope.registrar = registrar;
  userService.get().then(r => $scope.usuarioLogado = r.data);
  $scope.atualizar = atualizar;
  $scope.go = go;

  function go() {
    userService.getById($routeParams.id).then(r => $scope.usuarioLogado = r.data);
  }


  friendshipService.getSoli().then(response => console.log($scope.users = response.data.content));

  friendshipService.getNotFriends().then(response => console.log($scope.notFriends = response.data.content));

  function registrar(id){
    return friendshipService.post(id)
      .then(response => console.log(response.data))
  }

  function atualizar(id) {
    return friendshipService.put(id)
      .then(response => console.log(response.data))
  }

  var getFriends = function() {
    return friendshipService.getFriends().then(response => console.log($scope.friends = response.data.content));
  }

  getFriends();

});
