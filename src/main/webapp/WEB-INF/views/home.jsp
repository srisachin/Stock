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
		<script src="<c:url value="/resources/myService.js" />"></script>
	</head>

	<body ng-app ="myApp">

	<div ng-controller="select">		
  		<select ng-options="n for n in names" 
        ng-model="selected.item"
        ng-change="onChange(selected.item)">
		</select>
	</div>
	
	<div ng-controller="graph">
		<input type="text" ng-model="mySelected.item">
        <canvas id="line" class="chart chart-line" chart-labels="gs" chart-data="siri">
		</canvas>
    </div>

    <div ng-controller="current">
    <p>		
  		<select ng-options="n for n in names" 
        ng-model="selected"
        ng-change="onChange(selected)">
		</select>
		<table>
  			<tr ng-repeat="(key,value) in price">
    			<td>{{ key }}</td>
    			<td>{{ value }}</td>
  			</tr>
		</table>
	</p>
	</div>
    <br><br><br><br>
    <div ng-controller="google">
    <p>
		<input type="submit", value='Highest Stock Price', ng-click='googleTop()'/> 
		<table>
  			<tr ng-repeat="(key,value) in price">
    			<td>{{ key }}</td>
    			<td>{{ value }}</td>
  			</tr>
		</table>
	</p>
    </div>
        	
	</body>
</html>