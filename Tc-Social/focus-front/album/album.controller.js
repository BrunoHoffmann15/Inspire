angular.module('app').controller('AlbumController', function($scope, albumService, $routeParams, $localStorage, userService) {
  $scope.album ={};
  $scope.posts={};
  $scope.registrar = registrar;
  let id = $routeParams.id;

  userService.get().then(r => $scope.usuarioLogado = r.data);
  function registrar() {
    console.log($scope.album);
    return albumService.post($scope.album)
      .then(function(resp) {
        alert('ok');
      })
  }

  function setUp() {
    return albumService.getPosts(id).then(r => console.log( $scope.posts = r.data));
  }
  setUp();
})
