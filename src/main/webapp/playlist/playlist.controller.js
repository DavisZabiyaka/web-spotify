(function() {
    'use strict';

    angular
    .module('spotifyWebApp')
    .controller('PlaylistController', ['$cacheFactory', 'PlaylistService', PlaylistController]);

    function PlaylistController($cacheFactory, PlaylistService) {

        let $resourceCache = $cacheFactory.get('$http');
        var cachedData = [];

        this.playlists = PlaylistService.query(function(data) {
            data.forEach((element) => cachedData.push({playlistId: element.playlistId, playlistName: element.playlistName, author: element.author, noOfSongs: element.noOfSongs}));
            // data.forEach((element) => $resourceCache.put(element.playlistId, element));
            console.log($resourceCache.info());
            console.log($resourceCache.get(2));
        });

        console.log(cachedData);

        //this.playlists.forEach((element) => resourceCache.put(element.playlistId, element));
        //console.log(resourceCache.get(2));

        this.deletePlaylist = function(playlist) {
            console.log('Deleting playlist: ' + playlist.playlistId);
            PlaylistService.delete({ playlistId: playlist.playlistId }, function() {
                console.log("Successfully deleted playlist");
                $resourceCache.remove(2);
            });
            this.playlists.splice(this.playlists.indexOf(playlist), 1);
        }

    }
    
})();