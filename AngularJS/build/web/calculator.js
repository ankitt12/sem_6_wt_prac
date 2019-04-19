/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




 var app=angular.module('myModule', []);
    app.controller('myController', function($scope) {
            $scope.result = function() {
                if ($scope.operator === '+') {
                    return $scope.a + $scope.b;
                }
                if ($scope.operator === '-') {
                    return $scope.a - $scope.b;
                }
                if ($scope.operator === '*') {
                    return $scope.a * $scope.b;
                }
                if ($scope.operator === '/') {
                    return $scope.a / $scope.b;
                }
                
            };
        });