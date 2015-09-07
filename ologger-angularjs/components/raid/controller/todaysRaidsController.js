angular.module('RaidModule')
    .controller('TodaysRaidsController', function ($scope, $rootScope, $filter, RaidService) {

        $scope.raids = [];
        $scope.total = {
            metal: 0,
            crystal: 0,
            deuterium: 0,
        }

        $scope.labels = ["Metal", "Crystal", "Deuterium"];
        $scope.data = [0, 0, 0];

        $scope.getAllRaids = function () {
            var date = getCurrentDate();

            RaidService.getAllRaids($rootScope.name, date)
                .then(function (response) {
                    $scope.raids = response.data;
                });
        }

        $scope.updateTodaysTotal = function (data) {
            $scope.total.metal += data.metal + data.debrisMetal;
            $scope.total.crystal += data.crystal + data.debrisCrystal;
            $scope.total.deuterium += data.deuterium;

            $scope.data = [$scope.total.metal,  $scope.total.crystal, $scope.total.deuterium];
        }

        function getCurrentDate() {
            return $filter('date')(new Date(), "dd-MM-yyyy");
        }

        $rootScope.$on('newRaidAdded', function (event, data) {
            $scope.raids.push(data);
            $scope.updateTodaysTotal(data);
        });

        $scope.$watch('$ViewContentLoaded', function () {
            $scope.getAllRaids($rootScope.name, getCurrentDate());
        });
    });