angular.module('RaidModule')
    .directive('raidInput', function () {
        return {
            restrict: 'E',
            templateUrl: 'components/raid/view/raidInput.html',
            controller: 'RaidInputController'
        };
    });