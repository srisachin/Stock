app.service('myService', function($http, $rootScope) {
	this.selected = {
	        item: '' 
    }
	this.getData = function(key){
		return $http.get('/myapp/stocklist/'+key);
	}
	this.gs = [];	
	this.siri=[];
	var vm=this;
	
	this.names=[];
	
	this.cleanData = function(response){
		var sr = [];
		vm.gs.length = 0;
		vm.siri.length=0;
		for( var i=0; i<response.data.length; i++ ) {
		    vm.gs.push(response.data[i].date);
		    sr.push(response.data[i].high);
	    }	    	    	    
		vm.siri.push(sr);
	}
	this.onChange = function(key){
		vm.getData(key).then(function(response){
			vm.cleanData(response);
			console.log(key);
		});
	}

});