angular.module('FleetModule')
    .controller('FleetLossesController', function ($scope, FleetService) {

        $scope.calculateLosses = function (losses) {
            FleetService.calculateLosses(losses)
                .then(function (response) {
                    $scope.addNewLosses(response.data);
                })
        };

        $scope.addNewLosses = function (losses) {
            FleetService.addNewLosses(losses);
        }

    });