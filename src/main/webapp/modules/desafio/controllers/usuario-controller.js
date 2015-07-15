(function (angular) {
    'use strict';

/**
 *
 * @param $scope
 * @param $state
 */
angular.module('desafio')
    .controller('UsuarioController', function ( $scope, $state, $rootScope, $importService, $mdSidenav, $mdToast, $mdDialog, $log, $timeout, $q, $location ) {

    /**
     * Serviços importados do DWR
     */
	$importService("usuarioService");

    /*-------------------------------------------------------------------
     * 		 				 	ATTRIBUTES
     *-------------------------------------------------------------------*/
    //----STATES
    /**
     * Representa o estado de listagem de registros.
     */
    $scope.LIST_STATE = "usuario.list";
    /**
     * Representa o estado para a criação de registros.
     */
    $scope.ADD_STATE = "usuario.add";
    /**
     * Representa o estado para a edição de registros.
     */
    $scope.EDIT_STATE = "usuario.edit";
    /**
     * Representa o estado de detalhe de um registro.
     */
    $scope.DETAIL_STATE = "usuario.detail";

    
    //----FORM MODEL
    /**
     * Contém o estados dos filtros da tela
     * Contém estado da paginação inicial contendo sorting
     */
    $scope.model = {
        form: {},
        usuario: new Usuario(),

        filters: {
            terms: []
        },
        
        page: {//PageImpl
            content: null,
            pageable: {//PageRequest
                size: 9,
                page: 0,
                sort: {//Sort
                	 orders: [
                              { direction: 'DESC', property: 'created' }
                          ]
                }
            }
        }
    };
    
    /*-------------------------------------------------------------------
     * 		 				  POST CONSTRUCT
     *-------------------------------------------------------------------*/
    /**
     * Handler que escuta as mudanças de URLs pertecentes ao estado da tela.
     * Ex.: list, add, detail, edit
     *
     * Toda vez que ocorre uma mudança de URL se via botão, troca de URL manual, ou ainda
     * ao avançar e voltar do browser, este evento é chamado.
     *
     */
    $scope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {


        switch ( $state.current.name ) {
            case $scope.LIST_STATE: {
                $scope.changeToList(null,null);
                break;
            }
            case $scope.DETAIL_STATE: {
                $scope.changeToDetail( $state.params.id );
                break;
            }
            case $scope.ADD_STATE: {
                $scope.changeToAdd();
                break;
            }
            case $scope.EDIT_STATE: {
                if ( $state.params.id && $state.params.id != 0 ) {
                    $scope.changeToEdit( $state.params.id );
                } else {
                    $mdToast.showSimple( "Identificador inválido." );
                    $state.go( $scope.LIST_STATE );
                }
                break;
            }
            default : {
                $state.go($scope.LIST_STATE);
            }
        }
    });
    
    /*-------------------------------------------------------------------
     * 		 				 	  HANDLERS
     *-------------------------------------------------------------------*/

    /**
     * Realiza os procedimentos iniciais (prepara o estado)
     * para a tela de consulta e após isso, muda o estado para list.
     * Para mudar para este estado, deve-se primeiro carregar os dados da consulta.
     *
     * @see $scope.LIST_STATE
     *
     * @param paginate boolean para saber se precisa paginar
     */
    
    
    $scope.changeToList = function ( usuarios, pageRequest ) {
        console.debug("changeToList");

        $scope.listUsuariosByFilters($scope.model.filters, $scope.model.page.pageable)
    };
    
		$scope.listUsuariosByFilters = function ( filters, pageRequest ) {
		    	
		    	usuarioService.listUsuariosByFilters( filters.terms.toString(), {
		            callback: function (result) {
		            	$scope.model.page = result;
		                $scope.$apply();
		            },
		            errorHandler: function (message, exception) {
		                $mdToast.showSimple(message);
		                $scope.$apply();
		            }
		        });
		    };
    
    
		    /**
		     * Handler para que realiza os procedimentos iniciais (prepara o estado)
		     * para a tela de inserção e após isso, muda o estado para $scope.ADD_STATE.
		     *
		     * @see $scope.ADD_STATE
		     */
    
    $scope.changeToAdd = function (usuarios, pageRequest ) {
        console.debug("changeToAdd");
        
        $scope.model.usuario = new Usuario();//Limpa o formulário
        
        $scope.model.usuario.status = "true";
    };
    
    
    /**
     * Realiza os procedimentos iniciais (prepara o estado)
     * para a tela de detalhe e após isso, muda o estado para detail.
     *
     * Para mudar para este estado, deve-se primeiro obter via id
     * o registro atualizado pelo serviço de consulta e só então mudar o estado da tela.
     *
     * @see $scope.DETAIL_STATE
     */
    
    $scope.changeToDetail = function ( id ) {
        console.debug("changeToDetail");
        
        $scope.model.usuario = new Usuario();//Limpa o formulário

        usuarioService.findUsuarioById(id, {
            callback: function (result) {
                $scope.model.usuario = result;             
                
                $state.go($scope.DETAIL_STATE, {id: id});
                $scope.$apply();
            },
            errorHandler: function (message, exception) {
                $mdToast.showSimple(message);
                $state.go($scope.LIST_STATE);
                $scope.$apply();
            }
        });

    };
    
    
    /**
     * Realiza os procedimentos iniciais (prepara o estado)
     * para a tela de edição e após isso, muda o estado para update.
     *
     * Para mudar para este estado, deve-se primeiro obter via id
     * o registro pelo serviço de consulta e só então mudar o estado da tela.
     *
     * @see $scope.EDIT_STATE
     */
    
    $scope.changeToEdit = function (id) {
        console.debug("changeToEdit");
        
        $scope.model.usuario = new Usuario();//Limpa o formulário

        usuarioService.findUsuarioById(id, {
            callback: function (result) {
                $scope.model.usuario = result;             
                
                $state.go($scope.EDIT_STATE, {id: id});
                $scope.$apply();
            },
            errorHandler: function (message, exception) {
                $mdToast.showSimple(message);
                $state.go($scope.LIST_STATE);
                $scope.$apply();
            }
        });

    };
    
     
    
    /**
     * Realiza a inserção de um novo registro
     * e no sucesso, modifica o estado da tela para o detail.
     */
    $scope.insertUsuarioHandler = function (  ) {
        console.debug("insertUsuarioHandler");
      

        if ($scope.model.usuario) {
            usuarioService.insertUsuario($scope.model.usuario, {
                callback: function (result) {
                    $mdToast.showSimple("Usuario cadastrado com sucesso!");
                    $state.go($scope.LIST_STATE);
                    $scope.$apply();
                   
                },
                errorHandler: function (message, exception) {
                    $mdToast.showSimple(message);
                    $scope.$apply();
                }
            });
        }
    };
    
    


  })
}(window.angular));