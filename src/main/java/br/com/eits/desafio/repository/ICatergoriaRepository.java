package br.com.eits.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.eits.desafio.entity.Categoria;

public interface ICatergoriaRepository extends JpaRepository<Categoria, Long> {
	
	
	/**
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT new Categoria(categoria.id, categoria.descricao) " +
				   "FROM Categoria categoria " +
				  "WHERE FILTER(categoria.descricao, :filter) = TRUE " )
	public Page<Categoria> listCategoriasByFilters( @Param("filter") String filter, Pageable pageable );

}
