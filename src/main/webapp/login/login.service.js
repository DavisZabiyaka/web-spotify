(function() {
    angular
        .module('spotifyWebApp')
        .factory('LoginService', ['$resource', LoginService]);

        function LoginService($resource) {
            return $resource('http://localhost:8080/login', {}, {
                get: {
                    method: 'GET',
                    params: {username: '@username', password: '@password'}
                },
                save: {
                    method: 'POST',
                    url: 'http://localhost:8080/user/create'
                }
            });
        }
})();