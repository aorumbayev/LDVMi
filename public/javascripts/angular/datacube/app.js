define([
        'angular',
        './controllers',
        './directives',
        './filters',
        './services',
        'angular-resource',
        'angular-route',
        'angular-ui',
        'ui.bootstrap',
        'angular-loading-bar'
    ],
    function (ng) {
        'use strict';

        return ng.module('dataCube', [
            'dataCube.services',
            'dataCube.controllers',
            'dataCube.filters',
            'dataCube.directives',
            'ngRoute',
            'ngResource',
            'ui.bootstrap',
            'angular-loading-bar'
        ]);
    });