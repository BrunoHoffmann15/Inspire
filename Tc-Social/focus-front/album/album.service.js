angular.module('app').factory('albumService', function($http) {
  let url = "http://localhost:9090/album";
  function post(album) {
    return $http.post(url + "/new", album);
  }
  function put(album) {
    return $http.put(url + "/edited", album);
  }
  function get() {
    return $http.get(url + "/albuns");
  }
  function remove(album) {
    return $http.delete(url + "/deleted", album);
  }
  function getPosts(id) {
    return $http.get(url + "/pictures/" + id);
  }

  return {
    post : post,
    put : put,
    get : get,
    remove : remove,
    getPosts : getPosts
  }
});
