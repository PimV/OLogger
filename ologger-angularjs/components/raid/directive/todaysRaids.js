angular.module('RaidModule')
    .directive('todaysRaids', function () {
        return {
            restrict: 'E',
            templateUrl: 'components/raid/view/todaysRaids.html',
            controller: 'TodaysRaidsController'
        };
    });