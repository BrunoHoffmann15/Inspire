angular.module('app').controller('FeedController', function($scope, postService, likeService, commentService, authService){
  $scope.auth = authService;
  $scope.posts = {};
  $scope.pictures = {};
  $scope.tags = {};
  $scope.comments = {};
  $scope.likes = {};
  $scope.comment= {};
  $scope.curtir = curtir;
  $scope.comentar = comentar;
  $scope.logout = authService.logout;;

setUp();
function setUp() {
  postService.getByUser().then(function(response){
     $scope.posts = response.data
  for(let n=1; n<$scope.posts.length; n++) {
    commentService.getByPost($scope.posts[n].id).then(function(r){
      console.log(r.data);
      $scope.comments = r.data;
    });
  }
  for(let j=1; j<$scope.posts.length; j++) {
  likeService.getByPost($scope.posts[j].id).then(response => console.log($scope.lilkes = response.data));
  }
  for(let i=1; i<$scope.posts.length; i++) {

    postService.getPicturesByPost($scope.posts[i].id)
    .then(function(response) {
      $scope.pictures = response.data
      // for(let k=1; k<$scope.pictures.length; k++) {
      //   postService.getTagsByPicture($scope.pictures[k].id)
      //   .then(response => console.log(response.data));
      // }

    })
  }
}
)
}


function curtir(id) {
  likeService.post(id).then(response => alert("ok!"));
}

function comentar(post) {
  $scope.comment.post = post;
  console.log($scope.comment);
  commentService.post($scope.comment).then(response => console.log("ok!"));
}





});
