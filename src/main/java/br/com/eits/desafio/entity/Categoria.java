/**
 * 
 */
package br.com.eits.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.directwebremoting.annotations.DataTransferObject;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.envers.Audited;

/**
 * @author eits
 *
 */
@Entity
@Audited
@DataTransferObject(javascript = "Categoria")
public class Categoria implements Serializable {

	
/**
	 * 
	 */
	private static final long serialVersionUID = -2575385312858639492L;

/*===================================================================================
 * 									ATRIBUTOS											    =
 * ==================================================================================	
 */
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
		
	/**
	 * 
	 */
	@Column(nullable = true, length = 255)
	private String descricao;
	
	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	
	/**
	 * 
	 */
	public Categoria()
	{
		
	}
	
	/**
	 * 
	 */
	public Categoria (Long id)
	{
		this.id = id; 
	}
	
	public Categoria (Long id, String descricao)
	{
		this(id);
		this.descricao = descricao;
		
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
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Categoria other = (Categoria) obj;
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
		return true;
	}
	
	/*===================================================================================
	 * 									GETER'S AND SETTER'S											    =
	 * ==================================================================================	
	 */
		
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

}
