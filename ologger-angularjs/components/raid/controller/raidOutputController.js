angular.module('RaidModule')
    .controller('RaidOutputController', function ($scope, $rootScope, $filter, RaidService) {

        $scope.raids = [];

        $scope.getAllRaids = function () {
            var date = getCurrentDate();

            RaidService.getAllRaids($rootScope.name, date)
                .then(function (response) {
                    $scope.raids = response.data;
                });
        }

        function getCurrentDate() {
            return $filter('date')(new Date(), "dd-MM-yyyy");
        }

        $rootScope.$on('newRaidAdded', function (event, data) {
            $scope.raids.push(data);

        });

        $scope.getAllRaids();
    });