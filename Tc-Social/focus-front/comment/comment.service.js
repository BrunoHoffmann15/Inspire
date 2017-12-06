angular.module('app').factory('commentService', function($http) {
  let url = "http://localhost:9090/comment";
  function post(comment) {
    return $http.post(url + "/new", comment);
  }

  function getByPost(id) {
    return $http.get(url + "/comments/" + id);
  }

  return {
    post : post,
    getByPost : getByPost
  }
})
