var app = angular.module('Application.controllers', [ 'ui.bootstrap' ]);

app
		.controller(
				'UserController',
				function($scope, $location, $routeParams, userService) {

					$scope.sortBy = 'birth';
					$scope.sortSmer = false;

					$scope.today = function() {
						$scope.dt = new Date();
					};
					$scope.today();
					$scope.checkIfDate = function() {
						return angular.isDate($scope.dt);
					}
					$scope.clear = function() {
						$scope.dt = null;
					};

					$scope.inlineOptions = {
						customClass : getDayClass,
						minDate : new Date(),
						showWeeks : true
					};

					$scope.dateOptions = {
						dateDisabled : disabled,
						formatYear : 'yy',
						maxDate : new Date(2020, 5, 22),
						minDate : new Date(),
						startingDay : 1
					};

					// Disable weekend selection
					function disabled(data) {
						var date = data.date, mode = data.mode;
						return mode === 'day'
								&& (date.getDay() === 9 || date.getDay() === 9);
					}

					$scope.toggleMin = function() {
						$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null
								: new Date();
						$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
					};

					$scope.toggleMin();

					$scope.open1 = function() {
						$scope.popup1.opened = true;
					};

					$scope.open2 = function() {
						$scope.popup2.opened = true;
					};

					$scope.setDate = function(year, month, day) {
						$scope.dt = new Date(year, month, day);
						$scope.user.birth = $scope.dt;
					};

					$scope.formats = [ 'dd-MMMM-yyyy', 'yyyy/MM/dd',
							'dd.MM.yyyy', 'shortDate' ];
					$scope.format = $scope.formats[0];
					$scope.altInputFormats = [ 'M!/d!/yyyy' ];

					$scope.popup1 = {
						opened : false
					};

					$scope.popup2 = {
						opened : false
					};

					var tomorrow = new Date();
					tomorrow.setDate(tomorrow.getDate() + 1);
					var afterTomorrow = new Date();
					afterTomorrow.setDate(tomorrow.getDate() + 1);
					$scope.events = [ {
						date : tomorrow,
						status : 'full'
					}, {
						date : afterTomorrow,
						status : 'partially'
					} ];

					function getDayClass(data) {
						var date = data.date, mode = data.mode;
						if (mode === 'day') {
							var dayToCheck = new Date(date)
									.setHours(0, 0, 0, 0);

							for (var i = 0; i < $scope.events.length; i++) {
								var currentDay = new Date($scope.events[i].date)
										.setHours(0, 0, 0, 0);

								if (dayToCheck === currentDay) {
									return $scope.events[i].status;
								}
							}
						}

						return '';
					}
					$scope.init = function() {
						$scope.deletebt = true;
						$scope.page = 0;
						$scope.user = {};
						$scope.user.birth = null;
						if ($routeParams.id) {
							userService.findOne($routeParams.id).success(
									function(data, status, headers) {
										$scope.user = data;
									}).error(function() {
								alert('Greska Kod Ucitavanja Usera')
							})
						}
					}

					$scope.getAll = function() {
						userService
								.getAll($scope.search, $scope.page,
										$scope.sortBy)
								.success(
										function(data, status, headers) {
											$scope.users = data;
											$scope.totalPages = headers('total-pages');
											$scope.totalElements = headers('total-elements');
										}).error(function() {
									$scope.glyph = true;
									$scope.moveAway = true;
								})
					}
					$scope.findHim = function() {
						userService
								.getAll($scope.search, $scope.page,
										$scope.sortBy, $scope.user.firstname,
										$scope.user.lastname)
								.success(
										function(data, status, header) {
											$scope.activities = data;
											$scope.imali = data.length > 0;
											if ($scope.imali == false) {
												$scope.save();
											}
											$scope.totalElements = header('total-elements');
										}).error(function() {
									$scope.glyph = true;
									$scope.moveAway = true;
								})
					}

					$scope.sortAll = function() {
						userService
								.getAll($scope.search, $scope.page,
										$scope.sortBy)
								.success(
										function(data, status, headers) {
											$scope.users = data;
											$scope.totalPages = headers('total-pages');
											$scope.totalElements = headers('total-elements');
										}).error(function() {
									$scope.glyph = true;
									$scope.moveAway = true;
								})
					}

					$scope.remove = function(id) {
						userService.remove(id).success(function() {
							$scope.getAll();
						}).error(function() {
							alert('Greska Kod Ucitavanja Usera')
						})
					}

					$scope.save = function() {
						userService.add($scope.user).success(function() {
							$location.path('/users')
						}).error(function() {
							alert('Greska Kod Ucitavanja Usera')
						})
					}

				});

app.controller('ActivityController', function($scope, $location, $routeParams,
		activityService) {

	$scope.sakriSave = false;
	$scope.currentPage = 1;

	$scope.brisis = [ 4, 6, 8 ];
	$scope.setPage = function(pageNo) {
		$scope.currentPage = pageNo;
		$scope.page = $scope.currentPage;
	};

	$scope.pageChanged = function() {
		$scope.page = $scope.currentPage - 1;
		$scope.getAll();
	};

	$scope.onChangeSearch = function() {
		$scope.getAll();
	}

	$scope.srednjaVrednost = function(lista){
		var uku = 0;
		for(var i = 0; i<lista.length;i++){
			uku =uku + lista[i]
		}
		return uku/lista.length;
	}

	$scope.init = function() {
		$scope.deletebt = true;
		$scope.brojElemenata = 3;
		$scope.page = 0;
		$scope.activity = {};
		if ($routeParams.id) {
			activityService.getOne($routeParams.id).success(function(data) {
				$scope.activity = data;
			}).error(function() {
				alert('Greska Kod Ucitavanja Activitia')
			})
		}
	}
	$scope.getAll = function() {
		activityService
				.getAll($scope.search, $scope.page, $scope.brojElemenata)
				.success(function(data, status, header) {
					$scope.activities = data;
					$scope.totalPages = header('total-pages');
					$scope.totalElements = header('total-elements');
				}).error(function() {
					$scope.glyph = true;
					$scope.moveAway = true;
				})
	}

	$scope.remove = function(id) {
		activityService.remove(id).success(function(data) {
			$scope.deleted = data;
			$scope.izbrisan = true;
			$location.path('/activities');
			$scope.getAll();
		}).error(function() {
			alert('Greska kod brisanja activiti-a');
		})
	}

	$scope.save = function() {
		activityService.add($scope.activity).success(function(data) {
			$location.path('/activities')
		}).error(function() {
			alert('Greska Kod Ucitavanja Activitia')
		})
	}
	
	$scope.pushOcenu = function(){
		$scope.activity.ocene.push($scope.rate);
	}
	
	  $scope.rate = null;
	  $scope.max = 10;
	  $scope.isReadonly = false;

	  $scope.hoveringOver = function(value) {
	    $scope.overStar = value;
	    $scope.percent = 100 * (value / $scope.max);
	  };

	  $scope.ratingStates = [
	    {stateOn: 'glyphicon-ok-sign', stateOff: 'glyphicon-ok-circle'},
	    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
	    {stateOn: 'glyphicon-heart', stateOff: 'glyphicon-ban-circle'},
	    {stateOn: 'glyphicon-heart'},
	    {stateOff: 'glyphicon-off'}
	  ];

});