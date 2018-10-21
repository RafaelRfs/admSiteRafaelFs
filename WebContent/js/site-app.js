var app = angular.module('servsAdm', ['ngSanitize']);

app.controller('editServices', function($scope,$http){
	$scope.titlePage = "Gerenciar Serviços: ";
	$scope.servicos = [];
	$scope.dataform = [];
	
	$scope.setNome =  function(){
		$scope.tp = ($scope.dataform.id == undefined || $scope.dataform.id == 0)? "Inserir " : "Editar ";
		$scope.tp += $scope.dataform.nome;
	}
	
	$scope.editMe = function(e, id){
		e.preventDefault();
		$scope.dataform= getData(id);
		$scope.tp = id > 0 ? "Editar "+$scope.dataform.nome : "Inserir "+$scope.dataform.nome;
		$('#EditModal').modal('show');
	}
	
	$scope.saveMe = function(){
		var dataSend = $scope.dataform;
		if(dataSend.id > 0 ){
		updateMe(dataSend);
		setData($scope.dataform);
		}else{
		insertMe(dataSend);
		}
	}
	
	$scope.deleteMe = function(e, id){
		e.preventDefault();
		deleteMe(id);
	}
});