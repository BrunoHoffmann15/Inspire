angular.module('app').controller('PostController', function($scope, postService, pictureService, albumService, tagService) {
  $scope.post = {};
  $scope.tag = {};
  $scope.registrar = registrar;
  albumService.get().then(response => console.log( $scope.albuns = response.data));

  function registrar() {
    return postService.post($scope.post)
      .then(function(resp) {
      console.log(resp.data);
      $scope.picture.idPost = resp.data.id;
      pictureService.post($scope.picture).then(function(resp) {
        console.log(resp.data);
        $scope.tag.picture = resp.data;
        tagService.post($scope.tag);
      })
    })
  }
})
