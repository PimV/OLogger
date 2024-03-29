angular.module('PlayerModule')
    .service('PlayerService', function ($http, $rootScope) {

        var url = 'http://89.99.235.245:12346/ologger-web/player';

        this.login = function (player) {

            $http.post(url, {
                name: player.name
            })
                .success(function (data, status, headers, config) {
                    $rootScope.$broadcast('player-login-success', player.name);
                })
                .error(function (data, status, headers, config) {
                    $rootScope.$broadcast('player-login-failure');
                })
        }

    });



