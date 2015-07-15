(function (angular) {
    'use strict';

    /**
     *
     */
    angular.module('desafio')
        .controller('MenuController', function ($scope, $state, $importService, $mdDialog, $mdSidenav, $mdToast, $timeout, $window, $location ) {

        	
        	  /*-------------------------------------------------------------------
             * 		 				 	ATTRIBUTES
             *-------------------------------------------------------------------*/

            /**
             *
             * @type {{formSurvey: {}, survey: Survey, showEvaluation: boolean, filters: {}, page: {content: null, pageable: {sort: {orders: *[]}}}}}
             */
        	
        	
            /*-------------------------------------------------------------------
             * 		 				 	  BEHAVIORS
             *-------------------------------------------------------------------*/

            /**
             * Fun��o respons�vel por voltar a p�gina para a lista
             * @param href
             */
            $scope.backPage = function( href ){
            	console.log('chegou');
                $window.location.href = '#/'+href.replace('.','/');
            };

            $scope.openLeftMenu = function () {
                $mdSidenav('left').toggle();
            };
            $scope.closeMenu = function () {
                $mdSidenav('left').close();
            };

            
            /*-------------------------------------------------------------------
             * 		 			         HANDLERS
             *-------------------------------------------------------------------*/
            
        });
}(window.angular));

