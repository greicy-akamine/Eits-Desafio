package br.com.eits.desafio.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eits.desafio.entity.Categoria;
import br.com.eits.desafio.entity.Produto;
import br.com.eits.desafio.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaRESTful {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public Page<Categoria> listCategorias()
	{
		return this.categoriaService.listCategoriasByFilters(null, null);
	}
	
	@RequestMapping("/a")
	public Page<Produto> listProdutos()
	{
		return this.categoriaService.listProdutosByFilters(null, null);
	}
}
