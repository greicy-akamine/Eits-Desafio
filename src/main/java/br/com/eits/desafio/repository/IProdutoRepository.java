package br.com.eits.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eits.desafio.entity.Produto;

/**
 * @author eits
 *
 */

public interface IProdutoRepository extends JpaRepository<Produto, Long>
{
//	/**
//	 * @param filter
//	 * @param pageable
//	 * @return
//	 */
//	@Query(value="SELECT new Produto(produto.id, produto.codigoProduto, produto.descricao, produto.observacao, produto.categoria) " +
//				   "FROM Produto produto " +
//				  "WHERE ( FILTER(produto.codigoProduto, :filter) = TRUE "
//				  	 + "OR FILTER(produto.descricao, :filter) = TRUE )" 
//				  	 + "OR FILTER (produto.observacao, :filter)= TRUE"
//				  	 + "OR FILTER (produto.categoria.descricao, :filter)= TRUE)")
//	public Page<Produto> listByFilters( @Param("filter") String filter, Pageable pageable );
}
