/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var myapp = angular.module('myapp',[]);
myapp.controller('CartForm', function($scope){
    $scope.cart = {
        items: [{ qty: '', description: '', cost: ''}]
    };

    $scope.addItem = function() {
        $scope.cart.items.push({ qty: '', description: '', cost: ''});
    };

    $scope.removeItem = function(index) {
        $scope.cart.items.splice(index, 1);
    };

    $scope.total = function() {
        var total = 0;
        angular.forEach($scope.cart.items, function(item) {
            total += item.qty * item.cost;
        });
        return total;
    };
}
);

