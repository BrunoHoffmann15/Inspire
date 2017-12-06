angular.module('app').factory('pictureService', function($http) {
  let url = "http://localhost:9090/picture";
  function post(picture) {
    return $http.post(url + "/new", picture);
  }

  return {
    post : post
  }
})
