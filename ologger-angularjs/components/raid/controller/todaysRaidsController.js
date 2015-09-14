angular.module('RaidModule')
    .controller('TodaysRaidsController', function ($scope, $rootScope, $filter, RaidService) {

        $scope.raids = [];
        $scope.total = {
            metal: 0,
            crystal: 0,
            deuterium: 0
        }

        $scope.labels = ["Metal", "Crystal", "Deuterium"];
        $scope.data = [0, 0, 0];

        $scope.getAllRaids = function () {
            var date = getCurrentDate();

            RaidService.getAllRaids($rootScope.name, date)
                .then(function (response) {
                    $scope.raids = response.data;

                    angular.forEach($scope.raids, function (value, key) {
                        $scope.updateTodaysTotal(value);
                    })
                });
        }

        $scope.updateTodaysTotal = function (data) {
            if (data.metal > 0) {
                $scope.total.metal += data.metal + data.debrisMetal;
                $scope.total.crystal += data.crystal + data.debrisCrystal;
                $scope.total.deuterium += data.deuterium;
            } else {
                $scope.total.metal = ($scope.total.metal + data.metal);
                $scope.total.crystal = ($scope.total.crystal + data.crystal);
                $scope.total.deuterium = ($scope.total.deuterium + data.deuterium);
            }

            $scope.data = [$scope.total.metal, $scope.total.crystal, $scope.total.deuterium];
        }

        function getCurrentDate() {
            return $filter('date')(new Date(), "dd-MM-yyyy");
        }

        $rootScope.$on('newRaidAdded', function (event, data) {
            $scope.raids.push(data);
            $scope.updateTodaysTotal(data);
        });

        $rootScope.$on('newFleetLossAdded', function (event, data) {
            $scope.raids.push(data);
            $scope.updateTodaysTotal(data)
        });

        $scope.$watch('$ViewContentLoaded', function () {
            $scope.getAllRaids($rootScope.name, getCurrentDate());
        });
    });