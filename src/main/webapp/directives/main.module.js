'use strict';

angular
    .module('spotifyWebApp')
    .directive('mainScreen', function() {
        return {
            templateUrl: 'directives/main-screen.html'
        };
    });