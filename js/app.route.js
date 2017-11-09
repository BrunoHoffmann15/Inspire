app.config(function($routeProvider){
  $routeProvider
  .when('/usuario', {
    templateUrl: 'usuario/index.html',
    controller: 'usuarioCtrl'
  })
  .when('/ideia', {
    templateUrl: 'templates/ideia.html',
    controller: 'ideiaCtrl'
  })
  .when('/feed', {
    templateUrl: 'ideia/feed.html',
    controller: 'feedCtrl'
  })
  .when('/usuario-detail', {
    templateUrl: 'usuario/detail.html',
    controller: 'usuarioDetailCtrl'
  })
  .when('/ideia-detail', {
    templateUrl: 'ideia/detail.html',
    controller: 'ideiaDetailCtrl'
  })
  .otherwise('/feed');
});
