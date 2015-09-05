angular.module('HomeModule', []);
angular.module('RaidModule', []);
angular.module('PlayerModule', []);

var OLogger = angular.module('OLogger', [
    'ngRoute',
    'HomeModule',
    'RaidModule',
    'PlayerModule'
]);
