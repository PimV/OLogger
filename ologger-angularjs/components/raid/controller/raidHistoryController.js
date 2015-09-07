angular.module('RaidModule')
    .controller('RaidHistoryController', function ($scope, $rootScope, RaidService) {

        $scope.raidHistory = [];

        $scope.getRaidHistory = function () {
            RaidService.getAllHistoryRaidsFromPlayer($rootScope.name)
                .then(function (response) {
                    $scope.raidHistory = response.data;
                })
        }

        $scope.$watch('$ViewContentLoaded', function () {
            $scope.getRaidHistory($rootScope.name);
        });
    });