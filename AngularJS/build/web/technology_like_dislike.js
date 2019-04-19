/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myModule', []);
        app.controller('myController',function($scope){
                    $scope.technologies=[
                    {name:"C#", likes:0, dislikes:0},
                    {name:"ASPNet", likes:0,dislikes:0},
                    {name:"SqlServer",likes:0,dislikes:0},
                    {name:"AngularJS",likes:0,dislikes:0}
                    ];
                    
                    $scope.incrementLikes=function(technology){
                    technology.likes++;
                    };
                    $scope.incrementDisLikes=function(technology){
                    technology.dislikes++;
                    };
                    });


