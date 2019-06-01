(function() {
    'use strict';

    angular
    .module('spotifyWebApp')
    .controller('PlaylistController', ['PlaylistService', PlaylistController]);

    function PlaylistController(PlaylistService) {
        this.playlists = PlaylistService.query(function(data) {
            data.forEach((element) => console.log({playlistId: element.playlistId, playlistName: element.playlistName, author: element.author, noOfSongs: element.noOfSongs}));
        });

        this.deletePlaylist = function(playlist) {
            console.log('Deleting playlist: ' + playlist.playlistId);
            PlaylistService.delete({ playlistId: playlist.playlistId }, function() {
                console.log("Successfully deleted playlist");
            });
            this.playlists.splice(this.playlists.indexOf(playlist), 1);
        }

    }
    
})();