angular.module('RaidModule')
    .service('RaidService', function ($http, $rootScope) {

        var url = 'http://localhost:9000/ologger-web/';

        this.addNewRaid = function (raid, playername) {

            $http.post(url + 'attack', {
                playerName: playername,
                attackDate: raid.attackDate,
                attackInfo: raid.raidInfo
            })
                .success(function (data, status, headers, config) {
                    $rootScope.$broadcast('newRaidAdded', data);
                })
                .error(function (data, status, headers, config) {
                    console.log('error');
                })
        };

        this.getAllRaids = function (playerName, date) {
            var params = 'attack/' + playerName + '/' + date;

            var promise = $http.get(url + params)
                .success(function (data, status, headers, config) {
                    return data;
                })
                .error(function (data, status, headers, config) {
                    console.log('error');
                });

            return promise;
        }

        this.getAllHistoryRaidsFromPlayer = function (playerName) {
            var promise = $http.get(url + 'history/' + playerName)
                .success(function (data, status, headers, config) {
                    return data;
                })
                .error(function (data, status, headers, config) {
                    console.log('error');
                });

            return promise;
        }
    });