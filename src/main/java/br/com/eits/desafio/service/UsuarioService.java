/**
 * 
 */
package br.com.eits.desafio.service;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.eits.desafio.entity.Categoria;
import br.com.eits.desafio.entity.Produto;
import br.com.eits.desafio.entity.Usuario;
import br.com.eits.desafio.repository.IProdutoRepository;
import br.com.eits.desafio.repository.IUsuarioRepository;

/**
 * @author eits
 *
 */

@Service
@Transactional
@RemoteProxy(name="usuarioService")
public class UsuarioService {

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	
	//Repositories
		/**
		 * 
		 */
		@Autowired
		private IUsuarioRepository usuarioRepository;
		//private Usuario usuario;
	
	
	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/
	
		/**
		 * 
		 * @param usuario
		 * @return
		 */
		public Usuario insertUsuario(Usuario usuario) {
			return this.usuarioRepository.save(usuario);
		}
		
				
		/**
		 * 
		 * @param id
		 * @return
		 */
		@Transactional(readOnly=true)	
		public Usuario findUsuarioById(Long id)
		{		
			final Usuario usuario = this.usuarioRepository.findOne( id );
			Assert.notNull(usuario, "Nenhum registro foi encontrado.");
			return usuario;
		}
		
//		public boolean changeStatus(Usuario usuario)
//		{
//			return usuarioRepository.changeStatus(usuario);
//		}
//		
			
		/**
		 * 
		 * @param support
		 * @return
		 */
		public Usuario updateUsuario(Usuario usuario)
		{
			return usuarioRepository.save(usuario);
		}
		
		/**
		 * 
		 * @param pageable
		 * @param filters
		 * @return
		 */
		@Transactional(readOnly = true)
		public Page<Usuario> listUsuariosByFilters(String filter, PageRequest pageable) {
			return this.usuarioRepository.findAll(pageable);
		}
				
		
		/*-------------------------------------------------------------------
		 *				 		   	SURVEY
		 *-------------------------------------------------------------------*/	
		
		
}

	

