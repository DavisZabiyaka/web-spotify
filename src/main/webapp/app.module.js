'use strict';

angular
    .module('spotifyWebApp', [
        'ui.bootstrap',
        'ngRoute',
        // 'ngMaterial',
        'ngResource'
    ])
    .config(function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('');
        $routeProvider
            .when('/home', 
            {
                controller: 'HomeController',
                controllerAs: 'HomeCtrl',
                templateUrl: 'partials/home.html'
            })
            .when('/search',
            {
                controller: 'SearchController',
                controllerAs: 'SearchCtrl',
                templateUrl: 'partials/search.html'
            })
            .when('/library',
            {
                controller: 'LibraryController',
                controllerAs: 'LibraryCtrl',
                templateUrl: 'partials/library.html'
            })
            .when('/playlist',
            {
                // controller: 'PlaylistController',
                // controllerAs: 'pCtrl',
                templateUrl: 'partials/playlist.html'
            })
            .otherwise({
                redirectTo: '/home'
            });
    });