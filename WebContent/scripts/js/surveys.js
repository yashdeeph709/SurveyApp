(function(){
	var dataUrls = {
			surveys: 'http://localhost:8080/XoriantSurveyPortal/Xoriant/Surveys'
		},
		allSurveys = [];

	angular.module('surveys', [])
		.service('surveyDataService', function ($http, $log){
			this.getSurveys = function () {
				return $http.get(dataUrls.surveys);
			};
		})
		.controller('SurveysController', function($scope, $log, surveyDataService, $stateParams, $state, $rootScope){
			$scope.surveys = allSurveys || [];
			$rootScope.pageClass = 'surveys';
			function init() {
				if(allSurveys.length === 0){
					surveyDataService.getSurveys().then(loadSurveys);
				}
				$log.info('$stateParams.id = ', $stateParams.id);
				if($stateParams.id){
					//surveyDataService.getSurveyById($stateParams.id).then(loadMovieInfo);
					//loadSurveyInfo()
				}
			}
			function loadSurveys(surveys) {
				//	load survey list into UI
				$log.log('Surveys: ', surveys);
				$scope.surveys = allSurveys = surveys.data;
			}
			function loadSurveyInfo(survey) {
				$log.log('Survey: ', survey);
				$scope.survey = survey.data;
			}
			init();
		});
})();