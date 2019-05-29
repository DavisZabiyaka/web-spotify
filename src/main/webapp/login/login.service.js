(function() {
    angular
        .module('spotifyWebApp')
        .factory('LoginService', ['$resource', LoginService]);

        function LoginService($resource) {
            return $resource('', {}, {
                query: {
                    url: 'http://localhost:8080/users',
                    method: 'GET',
                    isArray: true,
                    cache: true
                },
                save: {
                    url: 'http://localhost:8080/user/create',
                    method: 'POST'
                },
                get: {
                    method: 'GET',
                    params: {username: '@username', password: '@password'}
                }
            });
        }
})();