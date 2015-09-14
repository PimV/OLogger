angular.module('HomeModule', []);
angular.module('RaidModule', ['chart.js']);
angular.module('PlayerModule', []);
angular.module('FleetModule', []);

var OLogger = angular.module('OLogger', [
    'ngRoute',
    'HomeModule',
    'RaidModule',
    'PlayerModule',
    'FleetModule'
]);
