angular.module('app').factory('userService', function($http) {
  let url = "http://localhost:9090/user"
  post = function(user) {
    return $http.post(url + "/new", user);
  }
  function put(user) {
    return $http.put(url + "/edited", user);
  }
  function remove(user) {
    return $http.delete(url + "/deleted", user);
  }
  function get() {
    return $http.get(url + "/current");
  }
  function getAlbuns() {
    return $http.get(url + "/albuns");
  }
  function getById(id) {
    return $http.get(url +"/" + id);
  }

  return {
    post: post,
    put: put,
    remove : remove,
    get: get,
    getAlbuns : getAlbuns
  }
});
