(function() {
    'use strict';

    angular
        .module('spotifyWebApp')
        .controller('LoginController', ['LoginService', LoginController]);

    function LoginController(LoginService) {
        let users = [];

        LoginService.query(function(data) {
            console.log('Querying users...');
            users = data;
            users.forEach((element) => console.log({userEmail: element.userEmail, encryptedPassword: element.encryptedPassword}));
        })

        this.login = function login() {
            console.log('Username: ' + this.email + ', Password: ' + this.password);
        }

        this.register = function register() {
            console.log('Registering new user...');
            let newUser = new LoginService();
            newUser.$save();
        }
    }

})();