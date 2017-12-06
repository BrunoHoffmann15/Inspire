angular.module('app')
  .controller('HomeController', function ($scope, authService, $http) {

    $scope.auth = authService;

  });
