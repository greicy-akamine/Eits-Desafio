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
import br.com.eits.desafio.repository.ICatergoriaRepository;
import br.com.eits.desafio.repository.IProdutoRepository;

/**
 * 
 * @author eits
 *
 */
@Service
@Transactional
@RemoteProxy(name="categoriaService")
public class CategoriaService {

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	// Repositories
	/**
	 * 
	 */
	@Autowired
	private ICatergoriaRepository categoriaRepository;
	
	/**
	 * 
	 */
	@Autowired
	private IProdutoRepository produtoRepository;

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/

	/**
	 * 
	 * @param categoria
	 * @return
	 */
	public Categoria insertCategoria(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Categoria findCategoriaById(Long id) {
		final Categoria categoria = this.categoriaRepository.findOne(id);
		Assert.notNull(categoria, "Nenhum registro foi encontrado.");
		return categoria;
	}

	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Categoria> listCategoriasByFilters(String filter, PageRequest pageable) {
//		return this.categoriaRepository.listCategoriasByFilters(filter, pageable);
		return this.categoriaRepository.findAll(pageable);
	}

	/**
	 * 
	 * @param support
	 * @return
	 */
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	/**
	 * 
	 * @param support
	 */
	public void removeCategoria(Long id) {
		this.categoriaRepository.delete(id);
	}
	/*-------------------------------------------------------------------
	 *				 		 PRODUTO
	 *-------------------------------------------------------------------*/
	
	/**
	 * 
	 * @param produto
	 * @return
	 */
	public Produto insertProduto(Produto produto)
	{
		return this.produtoRepository.save(produto);
		
	}
	
			
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)	
	public Produto findProdutoById(Long id)
	{		
		final Produto produto = this.produtoRepository.findOne( id );
		Assert.notNull(produto, "Nenhum registro foi encontrado.");
		return produto;
	}
	
	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Produto> listProdutosByFilters(String filter, PageRequest pageable) {
		return this.produtoRepository.findAll(pageable);
	}
	
	/**
	 * 
	 * @param support
	 * @return
	 */
	public Produto updateProduto(Produto produto)
	{
		return produtoRepository.save(produto);
	}
	
	/**
	 * 
	 * @param support
	 */
	public void removeProduto(Long id)
	{
		this.produtoRepository.delete( id );
	}
	
	
}
