angular.module('FleetModule')
    .controller('FleetLossesController', function ($scope, $window, FleetService) {

        $scope.calculateLosses = function (losses) {
            var formattedLosses = $scope.formatLosses(losses);

            FleetService.calculateLosses(losses)
                .then(function (response) {
                    $scope.addNewLosses(response.data);
                    $window.history.back();
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