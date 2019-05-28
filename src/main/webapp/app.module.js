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
            .otherwise({
                redirectTo: '/login'
            });
    });