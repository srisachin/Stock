var app = angular.module('myApp', ['ngRoute', 'chart.js']);

app.controller('graph', function($scope,$http, myService) {
	$scope.mySelected = myService.selected;
	console.log($scope.mySelected);
	myService.getData($scope.mySelected).then(function(response){
		myService.cleanData(response);
		$scope.siri=myService.siri;
		$scope.gs=myService.gs;
		console.log(myService.siri);
	});
});

app.controller('select', function($scope,$http, myService) {
	$scope.selected = myService.selected;
	$scope.onChange = myService.onChange;
	$http.get('/myapp/stocknames').	
   	success(function(data) {
   		$scope.names=data;
   		myService.names=data;   		
   	});
});

app.controller('current', function($scope,$http, myService) {
	$scope.getNames = function() {
	    return myService.names;
	}
	$scope.$watch("getNames()", function (data) {
		$scope.names=data;
	});
	$scope.onChange = function(selected){
		$http.get('/myapp/stockcurrent/'+selected).	
		success(function(data) {
			$scope.price=data;
		});
	}
});

app.controller('google', function($scope,$http, myService) {
	$scope.googleTop = function(selected){
		$http.get('/myapp/stockgoogle/').	
		success(function(data) {
			$scope.price=data;
		});
	}
});