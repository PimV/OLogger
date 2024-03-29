angular.module('RaidModule')
    .controller('RaidInputController', function ($scope, $filter, RaidService) {

        $scope.addNewRaid = function (raid) {
            raid.attackDate = getCurrentDate();
            RaidService.addNewRaid(raid, $scope.name);

            raid.raidInfo = '';
        };

        function getCurrentDate() {
            return $filter('date')(new Date(), "dd-MM-yyyy");
        }
    });