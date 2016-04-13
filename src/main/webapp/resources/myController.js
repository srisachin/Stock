var app = angular.module('myApp', ['ngRoute', 'chart.js']);

app.service('myService', function() {
	this.selected = {
	        item: '' // I want this to return the currently selected value - If val is changed to 'B', update the text input accordingly.
	    }
	});

app.controller('graph', ['$scope', '$http', 'myService', function($scope,$http, myService) {
	$scope.mySelected = myService.selected;
	console.log($scope.mySelected);
	//$http.get('/myapp/stocklist/'+ $scope.mySelected).
	$http.get('/myapp/stocklist/AMZN').
   	success(function(data) {
	gs = [];
	ser = [];    
	for( var i=0; i<data.length; i++ ) {
	    gs.push(data[i].name);
	    ser.push(data[i].high);
    }
    $scope.gs=gs;    
    $scope.ser=[];
    $scope.ser.push(ser);
   	});
}]);

app.controller('select', ['$scope', '$http', 'myService', function($scope,$http, myService) {
	$scope.selected = myService.selected;
	$http.get('/myapp/stocknames').
   	success(function(data) {
   		$scope.names=data;
   		console.log($scope.names);   		
   	});
}]);
