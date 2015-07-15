package br.com.eits.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.directwebremoting.annotations.DataTransferObject;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.envers.Audited;

/**
 * @author eits
 *
 */
@Entity
@Audited
@DataTransferObject(javascript = "Produto")
public class Produto implements Serializable
{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2589700795256482759L;

	/**
	 * 
	 */


/*===================================================================================
 * 									ATRIBUTOS										    =
 * ==================================================================================	
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	/**
	 * 
	 */
	@Column(nullable = true, length = 10)
	private int codigoProduto;
	/**
	 * 
	 */
	@Column(nullable = true, length = 144)
	private String descricao;
	/**
	 * 
	 */
	@Column(nullable = true, length = 255)
	private String observacao;
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	
	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	
	/**
	 * 
	 */
	public Produto()
	{
		
	}
	
	/**
	 * 
	 */
	public Produto (Long id)
	{
		this.id = id; 
	}
	
	public Produto (Long id, int codigoProduto, String descricao, String observacao, Categoria categoria)
	{
		this(id);
		this.categoria 		= categoria;
		this.codigoProduto	= codigoProduto;
		this.descricao		= descricao;
		this.observacao		= observacao;
		
	}
	
	/*===================================================================================
	 * 									BEHAVIORS											    =
	 * ==================================================================================	
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + codigoProduto;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigoProduto != other.codigoProduto)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
			 
	
	/*===================================================================================
	 * 									GETER'S AND SETTER'S								 	=
	 * ==================================================================================	
	 */
	
	
	/**
	 * @return the codigoProduto
	 */
	public int getCodigoProduto() {
		return codigoProduto;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param codigoProduto the codigoProduto to set
	 */
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
	
	