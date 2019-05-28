'use strict';

angular
    .module('spotifyWebApp', [
        'ui.bootstrap',
        'ngRoute',
        'ngResource'
    ])
    .configure(function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('');
        $routeProvider
            .when('/login',
            {
                controller: 'LoginController',
                templateUrl: 'partials/login.html'
            })
            .otherwise({
                redirectTo: '/login'
            });
    });