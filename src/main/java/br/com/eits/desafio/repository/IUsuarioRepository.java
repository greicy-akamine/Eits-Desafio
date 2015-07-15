/**
 * 
 */
package br.com.eits.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eits.desafio.entity.Usuario;

/**
 * @author eits
 *
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>
{
//	/**
//	 * 
//	 * @param filter
//	 * @param pageable
//	 * @return
//	 */
//	@Query(value="SELECT new Usuario(usuario.id, usuario.nome, usuario.departamento, usuario.email, usuario.status, usuariao.perfil.perfil) " +
//			   "FROM Usuario usuario " +
//			  "WHERE ( FILTER(usuario.nome, :filter) = TRUE "
//				  	 + "OR FILTER(usuario.departamento, :filter) = TRUE )" 
//				  	 + "OR FILTER (usuario.email, :filter)= TRUE"
//				  	 + "OR FILTER (usuario.status, :filter)= TRUE"
//				  	 + "OR FILTER (usuario.perfil.perfil, :filter)= TRUE)")
//public Page<Usuario> listByFilters( @Param("filter") String filter, Pageable pageable );
}
	

