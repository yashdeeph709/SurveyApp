/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';

	angular
		.module('ngSurveys', ['ui.router', 'ngAnimate', 'common-elements', 'home', 'surveys', 'surveyResponses','authentication'])

		//	UI Routing
		.config(function ($urlRouterProvider, $stateProvider,$httpProvider){
			$urlRouterProvider.otherwise('/home');
			$stateProvider
				.state('home', {
					url: '/home',
					templateUrl: 'views/home.html',
					controller: 'HomeController'
				})
				.state('survey', {
					url: '/survey',
					templateUrl: 'views/survey.html',
					controller: 'SurveyController'
				})
				.state('surveys', {
					url: '/surveys',
					templateUrl: 'views/surveyList.html',
					controller: 'SurveysController'
				})
				.state('responseInfo', {
					url: '/response/{id:[0-9]{1,4}}',
					templateUrl: 'views/surveyResponse.html',
					controller: 'SurveyResponseController'
				})
				.state('login', {
					url: '/login',
					templateUrl: 'views/login.html'
				})
				.state('register', {
					url: '/register',
					templateUrl: 'views/register.html'
				});;	
			$httpProvider.interceptors.push('authInterceptor');
		})
		.factory('authInterceptor',function(){
			return{
			request:function(config){
			var token=localStorage.getItem('Token');
			console.log("I am intercepting and token is"+token);
			 	if(token){
			 	config.headers.Authorization=token;
			 	}
			 	return config;
			},
			response:function(response){
				return response;
			}
		};
	});
})();