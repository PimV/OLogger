OLogger.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'components/home/view/home.html',
                controller: 'HomeController'
            })
            .when('/raid', {
                templateUrl: 'components/raid/view/raid.html'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);