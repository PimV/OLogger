angular.module('FleetModule')
    .controller('FleetLossesController', function ($scope, FleetService) {

        $scope.calculateLosses = function (losses) {
            var formattedLosses = $scope.formatLosses(losses);

            FleetService.calculateLosses(losses)
                .then(function (response) {
                    $scope.addNewLosses(response.data);
                })
        };

        $scope.addNewLosses = function (losses) {
            FleetService.addNewLosses(losses);
        }

        $scope.formatLosses = function (losses) {
            var losses = [];

            console.log(losses);
        }

    });