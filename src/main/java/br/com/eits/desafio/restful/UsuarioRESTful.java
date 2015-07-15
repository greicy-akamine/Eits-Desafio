package br.com.eits.desafio.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eits.desafio.entity.Usuario;
import br.com.eits.desafio.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioRESTful {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/")
	public Page<Usuario> listUsuarios()
	{
		return this.usuarioService.listUsuariosByFilters(null, null);
	}
}




	
	
