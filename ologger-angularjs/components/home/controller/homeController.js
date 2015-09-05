angular.module('HomeModule')
    .controller('HomeController', function ($scope, $rootScope, $window, PlayerService) {

        $scope.login = function(player) {
            PlayerService.login(player);
        }

        $rootScope.$on('player-login-success', function (event, data) {
            $rootScope.name = data;
            $window.location.href = '#/raid';
        });
    });