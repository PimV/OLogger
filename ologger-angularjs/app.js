angular.module('HomeModule', []);
angular.module('RaidModule', ['chart.js']);
angular.module('PlayerModule', []);

var OLogger = angular.module('OLogger', [
    'ngRoute',
    'HomeModule',
    'RaidModule',
    'PlayerModule'
]);
