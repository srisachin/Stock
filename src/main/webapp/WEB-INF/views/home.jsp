<!doctype html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<head>
		<title>Hello AngularJS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
		<link href="<c:url value="/resources/angular-chart.css" />" rel="stylesheet">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.1.0/Chart.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.7/angular-route.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="<c:url value="/resources/angular-chart.js" />"></script>
		<script src="<c:url value="/resources/myController.js" />"></script>
	</head>

	<body ng-app ="myApp">
	<div ng-controller="select">		
		<!-- select ng-model="selected.item">
  			<option ng-repeat="n in names" value="{{n}}">{{n}}</option>
  		</select-->
  		<select ng-options="n for n in names" 
        ng-model="selected.item"
        ng-change="change()">
		</select>
	</div>
	
	<div ng-controller="graph">
		<input type="text" ng-model="mySelected.item">
        <canvas id="line" class="chart chart-line" chart-labels="gs" chart-data="ser">
		</canvas> 
    </div>
    	
	</body>
</html>