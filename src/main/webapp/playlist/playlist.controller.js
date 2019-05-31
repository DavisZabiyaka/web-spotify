(function() {
    'use strict';

    angular
    .module('spotifyWebApp')
    .controller('PlaylistController', ['$scope','PlaylistService', PlaylistController]);

    function PlaylistController($scope, PlaylistService) {
        $scope.count = 0;
        let counting = 0;
        console.log(counting);

        PlaylistService.query(function(data) {
            $scope.playlists = data;
            data.forEach((element) => console.log({playlistId: element.playlistId, playlistName: element.playlistName, author: element.author, noOfSongs: element.noOfSongs}));
        });

        $scope.deletePlaylist = function(playlist) {
            let something = playlist;
            console.log(something);
            counting++;
            console.log(counting);
        }
    }
})();