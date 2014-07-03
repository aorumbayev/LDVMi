define(['./app'], function (app) {
    'use strict';

    app.config(['$routeProvider', '$locationProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: '/assets/javascripts/angular/datacube/partials/datacube.html', controller: 'DataCube', reloadOnSearch: false});
        $routeProvider.otherwise({redirectTo: '/'});
    }])
        .config(function ($provide) {
            $provide.decorator("$exceptionHandler", function ($delegate, $injector) {
                return function (exception, cause) {
                    alert("Unexpected error.");
                    $delegate(exception, cause);
                };
            });

        })
        .factory('errorHttpInterceptor', ['$q', function ($q, $modal) {
            return {
                responseError: function responseError(rejection) {

                    alert("Communication with server failed.");
                    return $q.reject(rejection);
                }
            };
        }])
        .config(['$httpProvider', function ($httpProvider) {
            $httpProvider.interceptors.push('errorHttpInterceptor');
        }])
        .config(['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
            cfpLoadingBarProvider.includeSpinner = false;
            cfpLoadingBarProvider.latencyThreshold = 0;
        }]);


});