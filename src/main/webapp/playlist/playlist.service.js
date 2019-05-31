(function() {
    angular
    .module('spotifyWebApp')
    .factory('PlaylistService', ['$resource', PlaylistService]);

    function PlaylistService($resource) {
        return $resource('http://localhost:8080/playlists/:playlistId', {}, {
            query: {
                method: 'GET',
                isArray: true,
                cache: true
            },
            save: {
                method: 'POST',
                url: 'http://localhost:8080/playlists/create'
            }
        });
            
    }
    
})();