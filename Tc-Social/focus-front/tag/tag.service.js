angular.module('app').factory('tagService', function($http) {
  let url = "http://localhost:9090/tag";
  function post(tag) {
    return $http.post(url + "/new", tag);
  }

  return {
    post : post
  }
});
