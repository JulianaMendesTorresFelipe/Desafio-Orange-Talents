package com.aplicacaovacina.orangetalents.models;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TB_VACINACAO")
public class AplicacaoDeVacina implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;	
		
		@Column(nullable=false)
		private String nomeVacina;
		
	    @Column(nullable=false)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="Brazil/East")
		private LocalDate dataDeVacina;

	    @OneToOne
	    @JoinColumn(name="email_usuario", referencedColumnName="email", nullable=false) 
	    private Usuario usuario;
	    
	    public AplicacaoDeVacina() {
		}
	    

		public AplicacaoDeVacina(int id, String nomeVacina, LocalDate dataVacina, Usuario usuario) {
			super();
			this.id = id;
			this.nomeVacina = nomeVacina;
			this.dataDeVacina = dataVacina;
			this.usuario = usuario;
		}
		
		
		public String getEmailUsuario() {
			return this.usuario.getEmail();
		}

		public void setId(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public String getNomeVacina() {
			return nomeVacina;
		}
		public void setNomeVacina(String nomeVacina) {
			this.nomeVacina = nomeVacina;
		}
		public LocalDate getDataDeVacina() {
			return dataDeVacina;
		}
		public void setDataDeVacina(LocalDate dataDeVacina) {
			this.dataDeVacina = dataDeVacina;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (prime * result) + ((nomeVacina == null) ? 0 : nomeVacina.hashCode());
			return result;
		}
			
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AplicacaoDeVacina other = (AplicacaoDeVacina)obj;
			if (nomeVacina == null) {
				if (other.nomeVacina != null)
					return false;
			} else if (!nomeVacina.equals(other.nomeVacina))
				return false;
			return true;
		}
}

