angular.module('app').factory('friendshipService', function($http) {
  let url = "http://localhost:9090/friendship";
  function post(id){
    return $http.post(url + "/new/" + id);
  }
  function getNotFriends() {
    return $http.get(url + "/not-friends");
  }
  function put(id) {
    return $http.put(url + "/edited/" + id);
  }
  function getSoli() {
    return $http.get(url + "/solicitations");
  }
  function getFriends() {
    return $http.get(url + "/friends");
  }
  return {
    post : post,
    getNotFriends : getNotFriends,
    put : put,
    getSoli : getSoli,
    getFriends : getFriends
  }
})
