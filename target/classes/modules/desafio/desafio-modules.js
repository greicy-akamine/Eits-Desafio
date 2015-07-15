(function(window, angular, undefined) {
	'use strict';

	//Start the AngularJS

	var module = angular.module('desafio', ['ngMaterial', 'ui.router', 'eits-dwr-broker', 'eits-md', 'ngMessages']);

	/**
	 *
	 */
	module.config( function( $stateProvider, $urlRouterProvider, $importServiceProvider, $mdThemingProvider ) {
       
		//-------
		//Broker configuration
		//-------
		$importServiceProvider.setBrokerURL("./broker/interface");

		//-------
		//URL Router
		//-------

		//HOME
        $urlRouterProvider.otherwise("/categoria/list");

        //CATEGORIA
        $stateProvider.state('categoria',{
        	abstract: true,
        	url : "/categoria",
        	template: '<div ui-view/>',
        	controller : 'CategoriaController as categoriaController'
        })
        .state('categoria.list',{
        	url : "/list",
        	templateUrl : "./modules/desafio/views/categoria/categoria-list.html"
        })
        .state('categoria.add',{
        	url : "/add",
        	templateUrl : "./modules/desafio/views/categoria/categoria-form.html"
        })
        .state('categoria.edit',{
        	url : "/edit/{id:[0-9]{1,10}}",
        	templateUrl : "./modules/desafio/views/categoria/categoria-form.html"
        })
        .state('categoria.detail',{
        	url : "/detail/{id:[0-9]{1,10}}",
        	templateUrl : "./modules/desafio/views/categoria/categoria-detail.html"
        });
        
        
        
      //PRODUTO
        $stateProvider.state('produto',{
        	abstract: true,
        	url : "/produto",
        	template: '<div ui-view/>',
        	controller : 'ProdutoController as produtoController'
        })
        .state('produto.list',{
        	url : "/list",
        	templateUrl : "./modules/desafio/views/produto/produto-list.html"
        })
        .state('produto.add',{
        	url : "/add",
        	templateUrl : "./modules/desafio/views/produto/produto-form.html"
        })
        .state('produto.edit',{
        	url : "/edit/{id:[0-9]{1,10}}",
        	templateUrl : "./modules/desafio/views/produto/produto-form.html"
        })
        .state('produto.detail',{
        	url : "/detail/{id:[0-9]{1,10}}",
        	templateUrl : "./modules/desafio/views/produto/produto-detail.html"
        });
        
       
        //USUARIO
        $stateProvider.state('usuario',{
        	abstract: true,
        	url : "/usuario",
        	template: '<div ui-view/>',
        	controller : 'UsuarioController as usuarioController'
        })
        .state('usuario.list',{
        	url : "/list",
        	templateUrl : "./modules/desafio/views/usuario/usuario-list.html"
        })
        .state('usuario.add',{
        	url : "/add",
        	templateUrl : "./modules/desafio/views/usuario/usuario-form.html"
        })
        .state('usuario.edit',{
        	url : "/edit/{id:[0-9]{1,10}}",
        	templateUrl : "./modules/desafio/views/usuario/usuario-form.html"
        })
        .state('usaurio.detail',{
        	url : "/detail/{id:[0-9]{1,10}}",
        	templateUrl : "./modules/desafio/views/usuario/usuario-detail.html"
        });
        
        
        
	});

	/**
	 *
	 */
	module.run( function( $rootScope, $window, $state, $stateParams ) {
		$rootScope.$state 		= $state;
		$rootScope.$stateParams = $stateParams;
	});

	/**
	 *
	 */
	angular.element(document).ready( function() {
		angular.bootstrap( document, ['desafio']);
	});

})(window, window.angular);