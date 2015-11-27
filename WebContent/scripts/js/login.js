/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';

	angular
		.module('authentication', [])
	.controller("loginController",function($scope,$http,$location){
		$scope.login=function(){
			var call={
					method:'GET', 
					url:'http://localhost:8080/XoriantSurveyPortal/Xoriant/Employees/loginuser', 
					params:{empId: $scope.username, password: $scope.password}
			}
			$http(call).success(function(data){
				localStorage.setItem("Token",data.Token);
				$location.path('survey');	
			});			
		}
	})
	.controller("registrationController",function($scope,$http,$location){
		$scope.register=function(){
			var call={
					method:'POST', 
					url:'http://localhost:8080/XoriantSurveyPortal/Xoriant/Employees', 
					params:{empId: $scope.eid,ename: $scope.username, password: $scope.password}
			}
			$http(call).success(function(data){
				localStorage.setItem("Message","User Account Created SuccessFully")
				$location.path('login');	
			});			
		}
	});
})();