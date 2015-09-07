angular.module('RaidModule')
    .directive('raidHistory', function () {
        return {
            restrict: 'E',
            templateUrl: 'components/raid/view/raidHistory.html',
            controller: 'RaidHistoryController'
        };
    });