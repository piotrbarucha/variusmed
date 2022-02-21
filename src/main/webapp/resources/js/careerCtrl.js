angular.module('MyApp').controller('CareerCtrl', function($scope, $http, Navigation) {

	$scope.getAvaJobs = function() {	  
	$http({	method : 'GET',	url : 'avaJobs.web'})
	.success(function(data, status, headers, config) {
		$scope.jobs = data;
	}).
	error(function(data, status, headers, config) {
		alert( "failure");
	});
	};   
	$scope.getAvaPlaces = function() {	  
		$http({	method : 'GET',	url : 'avaPlaces.web'})
		.success(function(data, status, headers, config) {
			$scope.places = data;
		}).
		error(function(data, status, headers, config) {
			alert( "failure");
		});
	};   
});     