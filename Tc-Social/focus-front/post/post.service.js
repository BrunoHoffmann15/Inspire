angular.module('app').factory('postService', function($http) {
  let url = "http://localhost:9090/post";
  function post(post) {
    return $http.post(url + "/new", post);
  }
  function put(post) {
    return $http.put(url + "/edited", post);
  }
  function getByAlbum(idAlbum) {
    return $http.get(url + "/posts-album "+ idAlbum);
  }
  function getByUser() {
    return $http.get(url + "/posts");
  }
  function remove(post) {
    return $http.delete(url + "/deleted", post);
  }

  function getPicturesByPost(post) {
    return $http.get(url + "/pictures/" + post);
  }

  function getTagsByPicture(picture) {
    return $http.get(url + "/tags/" + picture);
  }

  return {
    post : post,
    put : put,
    getByAlbum : getByAlbum,
    getByUser : getByUser,
    remove : remove,
    getPicturesByPost : getPicturesByPost,
    getTagsByPicture : getTagsByPicture
  }
});
