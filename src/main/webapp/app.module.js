'use strict';

angular
    .module('spotifyWebApp', [
        'ui.bootstrap',
        'ngRoute',
        'ngResource'
    ])
    .config(function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('');
        $routeProvider
            .when('/login',
            {
                controller: 'LoginController',
                controllerAs: 'LoginCtrl',
                templateUrl: 'partials/login.html'
            })
            .when('/register',
            {
                controller: 'LoginController',
                controllerAs: 'LoginCtrl',
                templateUrl: 'partials/createUser.html'
            })
            .otherwise({
                redirectTo: '/login'
            });
    });