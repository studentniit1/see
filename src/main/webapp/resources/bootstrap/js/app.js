var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'pages/home.jsp',
    controller  : 'HomeController'
  })

  .when('/blog', {
    templateUrl : 'pages/blog.jsp',
    controller  : 'BlogController'
  })

  .when('/about', {
    templateUrl : 'pages/about.jsp',
    controller  : 'AboutController'
  })

  .otherwise({redirectTo: '/'});
});
