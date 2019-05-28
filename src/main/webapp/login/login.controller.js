(function() {
    'use strict';

    angular
        .module('spotifyWebApp')
        .controller('LoginController', ['LoginService', LoginController]);

    function LoginController(LoginService) {

        this.login = function login() {
            console.log('Username: ' + this.email + ', Password: ' + this.password);
        }
    }

})();