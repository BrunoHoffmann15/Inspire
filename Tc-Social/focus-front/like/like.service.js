angular.module('app').factory('likeService', function($http) {
  let url = "http://localhost:9090/like";
  function post(id) {
    return $http.post(url + "/new/" + id);
  }

  function getByPost(id) {
    return $http.get(url + "/likes/" + id);
  }

  return {
    post : post,
    getByPost : getByPost
  }
});
