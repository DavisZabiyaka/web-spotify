(function() {
    'use strict';

    angular
        .module('spotifyWebApp')
        .controller('LoginController', ['$scope', '$location', 'LoginService', LoginController]);

    function LoginController($scope, $location, LoginService) {
        $scope.hideMain = false;
        // let users = [];

        // LoginService.query(function(data) {
        //     console.log('Querying users...');
        //     users = data;
        //     users.forEach((element) => console.log({userEmail: element.userEmail, encryptedPassword: element.encryptedPassword}));
        // })

        this.login = function login() {
            console.log('Username: ' + this.email + ', Password: ' + this.password);
        }

        this.register = function register() {
            console.log('Registering new user...');
            let newUser = new LoginService();
            newUser.$save(function(user) {
                console.log('Successfully created user: ' + {userEmail: user.userEmail, encryptedPassword: user.encryptedPassword});
                $location.path('#/home')
                // $scope.hideMain = false;
            }, function(error) {
                if (error.status === 409) {
                    console.log('User already exists!');
                } else {
                    console.log(error);
                    console.log('Something went wrong');
                }
            });
        }
    }

})();