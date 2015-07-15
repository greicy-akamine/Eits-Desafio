package br.com.eits.desafio.entity;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject(type = "enum", javascript = "Perfil")
public enum Perfil{
	
	/*-------------------------------------------------------------------
	*	ENUMS
	*-------------------------------------------------------------------*/
	ADMINISTRATOR, // 0
	USUARIO // 1
	
}