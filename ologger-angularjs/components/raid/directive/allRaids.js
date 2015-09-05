angular.module('RaidModule')
    .directive('allRaids', function () {
        return {
            restrict: 'E',
            templateUrl: 'components/raid/view/allRaids.html',
            controller: 'RaidOutputController'
        };
    });