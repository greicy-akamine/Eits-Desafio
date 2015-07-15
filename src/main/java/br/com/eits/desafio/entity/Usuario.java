/**
 * 
 */
package br.com.eits.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author eits
 *
 */
@Entity
@Audited
@Table(name="usuario")
@DataTransferObject(javascript = "Usuario")
public class Usuario implements Serializable 
{
	
	private static final long serialVersionUID = 5472498964961321580L;

	/**
	 * 
	 */
	
	
/*===================================================================================
 * 									ATRIBUTOS											    =
 * ==================================================================================	
 */
		/**
		 * 
		 */
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		protected Long id;
				
		/**
		 * 
		 */
		@NotEmpty
		@Column(nullable = false, length = 144)
		private String nome;
		/**
		 * 
		 */
		
		@Column(nullable = true, length = 144)
		private String departamento;
		/**
		 * 
		 */
		
		@Email
		@NotNull
		@Column(nullable = false, length = 144, unique = true)
		private String email;
		/**
		 * 
		 */
		
		@NotBlank
		@Length(min = 8)
		@Column(nullable = false, length = 20)
		private String senha;
		/**
		 * 
		 */
				
		@NotNull
		@Column(nullable = false)
		private boolean status;
		
		
		@Column(nullable = false)
		@Enumerated(EnumType.ORDINAL)
		private Perfil perfil;
		
		/*-------------------------------------------------------------------
		 * 		 					CONSTRUCTORS
		 *-------------------------------------------------------------------
		 */
		
		/**
		 * 
		 */
		public Usuario()
		{
			
		}
		
		/**
		 * 
		 * @param id
		 */
		public Usuario (Long id)
		{
			this.id = id;
		}
		
		
		public Usuario (Long id, String nome, String departamento, String email, boolean status, Perfil perfil)
		{
			this(id);
			this.nome 			= nome;
			this.departamento 	= departamento;
			this.email			= email;
			this.status			= status;
			this.perfil			= perfil;
		}
		
/*===================================================================================
 * 									BEHAVIORS											    =
 * ==================================================================================	
 */
//		/**
//		 * 
//		 */
//		@Override
//		@Transient
//		public Set<GrantedAuthority> getAuthorities()
//		{
//			final Set<GrantedAuthority> authorities = new HashSet<>();
//
//			if ( perfil == null )
//			{
//				return null;
//			}
//			
//			authorities.add( perfil );
//
//			if ( perfil.equals( Perfil.ADMINISTRATOR ) )
//			{
//				authorities.add( Perfil.USUARIO );
//			}
//
//			return authorities;
//		}
//
//		
//		
//		@Override
//		@Transient
//		public boolean isStatus()
//		{
//			return this.status;
//		}
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((departamento == null) ? 0 : departamento.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result
					+ ((perfil == null) ? 0 : perfil.hashCode());
			result = prime * result + ((senha == null) ? 0 : senha.hashCode());
			result = prime * result + (status ? 1231 : 1237);
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
			Usuario other = (Usuario) obj;
			if (departamento == null) {
				if (other.departamento != null)
					return false;
			} else if (!departamento.equals(other.departamento))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (perfil != other.perfil)
				return false;
			if (senha == null) {
				if (other.senha != null)
					return false;
			} else if (!senha.equals(other.senha))
				return false;
			if (status != other.status)
				return false;
			return true;
		}
		
/*===================================================================================
 * 									GETER'S AND SETTER'S											    =
 * ==================================================================================	
 */
		
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
		 * @return the nome
		 */
		public String getNome() {
			return nome;
		}

		/**
		 * @param nome the nome to set
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}

		/**
		 * @return the departamento
		 */
		public String getDepartamento() {
			return departamento;
		}

		/**
		 * @param departamento the departamento to set
		 */
		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the senha
		 */
		public String getSenha() {
			return senha;
		}

		/**
		 * @param senha the senha to set
		 */
		public void setSenha(String senha) {
			this.senha = senha;
		}

		/**
		 * @return the status
		 */
		public boolean isStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(boolean status) {
			this.status = status;
		}

		/**
		 * @return the perfil
		 */
		public Perfil getPerfil() {
			return perfil;
		}

		/**
		 * @param perfil the perfil to set
		 */
		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}

		
}


		