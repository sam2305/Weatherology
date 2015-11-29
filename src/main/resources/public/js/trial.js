// create angular app
	var app = angular.module('validationApp', []);

	// create angular controller
	app.controller('mainController', function($scope) {

		// function to submit the form after all validation has occurred			
		$scope.submitForm = function() {

			// check to make sure the form is completely valid
			if ($scope.userForm.$valid) {
				alert('our form is amazing');
        $scope.userForm.$setUntouched();
			}

		};

	});