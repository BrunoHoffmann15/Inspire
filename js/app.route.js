app.config(function($routeProvider){
  $routeProvider
  .when('/usuario', {
    templateUrl: 'templates/perfil.html',
    controller: 'usuarioCtrl'
  })
  .when('/ideia/:id', {
    templateUrl: 'templates/ideia.html',
    controller: 'ideiaCtrl'
  })
  .when('/feed', {
    templateUrl: 'templates/feed.html',
    controller: 'feedCtrl'
  })
  .when('/usuario-detail', {
    templateUrl: 'templates/perfil-detail.html',
    controller: 'usuarioDetailCtrl'
  })
  .when('/ideia-detail', {
    templateUrl: 'templates/ideia-detail.html',
    controller: 'ideiaDetailCtrl'
  })
  .when('/login', {
    templateUrl: 'templates/login.html',
    controller: 'loginCtrl'
  })
  .otherwise('/login');
});
