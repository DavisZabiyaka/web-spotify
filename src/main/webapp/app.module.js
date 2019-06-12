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
                templateUrl: 'home/home.html'
            })
            .when('/search',
            {
                controller: 'SearchController',
                controllerAs: 'SearchCtrl',
                templateUrl: 'search/search.html'
            })
            .when('/library',
            {
                controller: 'LibraryController',
                controllerAs: 'LibraryCtrl',
                templateUrl: 'library/library.html'
            })
            .when('/playlist',
            {
                controller: 'PlaylistController',
                controllerAs: 'pCtrl',
                templateUrl: 'playlist/playlist.html'
            })
            .otherwise({
                redirectTo: '/home'
            });
    });