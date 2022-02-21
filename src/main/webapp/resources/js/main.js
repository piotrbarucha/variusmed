//##################################################################
// a \u0105
// c \u0107
// e \u0119
// l \u0142
// n \u0144
// o \u00F3
// s \u015B
// z \u017C
// x \u017A
// A \u0104
// C \u0106
// E \u0118
// L \u0141
// N \u0143
// O \u00D3
// S \u015A
// Z \u017B
// X \u0179

// Code goes here
//angular.module('MyApp', []);
//var app = angular.module('MyApp', []);

'use strict';

var app = angular.module('CoreApp', ['ngAnimate', 'ngTouch', 'ngDialog','jcs-autoValidate']);
  
app.run([
    'bootstrap3ElementModifier',
    function (bootstrap3ElementModifier) {
        bootstrap3ElementModifier.enableValidationStateIcons(true);
    }]);

app.controller('MainCtrl', function($scope,$http,$sce, Navigation, ngDialog) {
    $scope.sidebar = Navigation;
	$scope.city = '';
	$scope.cities = ['Cieszyn','Jastrzębie Zdrój'];

	$scope.currentPage = {path:'Info'};

	$scope.getCityName - function(){
		if ($scope.city === "cieszyn") {
			return $scope.cities[0];
		} else {
			return $scope.cities[1];
		}
        return "";
	}
	var vm = this;

	vm.setActive = function(ind) {
		alert(ind);
		for (var i = 0, len = vm.isActive.length; i < len; i++) {
			vm.isActive[i] = i === ind;
		}
	}

    $scope.getMenuItemClicked = function(taskId) {
		$scope.currentPage = taskId;
		Navigation.loadSide($scope.currentPage,$scope.city);
	}

	$scope.trustSrc = function(src) {
		return $sce.trustAsResourceUrl(src);
	}
	$scope.setCity = function(item) {
		$scope.city = item;
		Navigation.loadSide($scope.currentPage,$scope.city);
	}

	$scope.loadSide = function(){
		Navigation.loadSide($scope.currentPage,$scope.city);
	}
	$scope.isActiveCieszyn = function(){
		if ($scope.city === "cieszyn") {
			return "active btn btn-city right";
		} else {
			return "btn btn-city right";
		}
	}

	vm.isActive =[];
	for(var i=0; i < 4; i++){
		vm.isActive[i] = false;
	}
	$scope.isActiveItem = function(page){
		return page.path === $scope.currentPage.path;
	}
	$scope.isActiveJastrzebie = function(){
		if ($scope.city === "jastrzebie") {
			return "active btn btn-city left";
		} else {
			return "btn btn-city left";
		}
	}
	$scope.isActiveCity = function(item){
		return item === $scope.city;
	}
	$scope.appliedClass = function(itemTop){
		if (itemTop.path === $scope.currentPage.path) {
			return "btn btn-marta1 ng-click-active";
		} else {
			return "btn btn-marta1"; // Or even "", which won't add any additional classes to the element
		}
	}

	$scope.getMenuFromServer = function() {	    	
		$http({method: 'GET', url: 'springSimpleMenuJS.web'}).
		success(function(data, status, headers, config) {
			$scope.menu = data;
			Navigation.loadSide(data[0],$scope.city);
		}).
		error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});	
	};
	$scope.openContactForm = function() {
		ngDialog.open({template: 'contact_us.html'});
	};
});

app.factory('Navigation', function($rootScope) {
  return {
    location: '',
    
    loadSide: function(msg, city) {
    	this.location =  city + '/' + msg.path + '.jsp';
		//alert(city);

    	this.broadcastEvent('addHand');
    },
    
    broadcastEvent: function(msg) {
      $rootScope.$broadcast(msg);
    }
  }
});