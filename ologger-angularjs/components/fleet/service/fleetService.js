angular.module('FleetModule')
    .service('FleetService', function ($http, $rootScope) {

        var url = 'http://89.99.235.245:12346/ologger-web/';

        this.addNewLosses = function (losses) {
            $http.post(url + 'fleetLoss', {
                playerName: $rootScope.name,
                metal: losses.metal,
                crystal: losses.crystal,
                deuterium: losses.deuterium
            })
                .success(function (data, status, headers, config) {
                    $rootScope.$broadcast('newFleetLossAdded', data);
                })
                .error(function (data, status, headers, config) {
                    console.log('error')
                })
        }

        this.calculateLosses = function (losses) {
            var promise = $http.post(url + 'fleetLoss/calculate', losses)
                .success(function (data, status, headers, config) {
                    return data;
                })
                .error(function (data, status, headers, config) {
                    console.log('error')
                })

            return promise;
        }
    });
