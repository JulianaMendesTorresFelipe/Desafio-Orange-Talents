package com.aplicacaovacina.orangetalents.models;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;


public class AplicacaoDeVacinaDTO {
	
		private int id;	
		
		
		private String nomeVacina;
	  
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="Brazil/East")
		private LocalDate dataDeVacina;
		
	    private String emailUsuario;
	    
	    
	    public AplicacaoDeVacina toEntity(Usuario usuario) {
			return new AplicacaoDeVacina(this.id, this.nomeVacina, this.dataDeVacina, usuario);
		}
	    
	    public String getEmailUsuario() {
			return emailUsuario;
		}

		public void setEmailUsuario(String emailUsuario) {
			this.emailUsuario = emailUsuario;
		}

		public AplicacaoDeVacinaDTO() {
		}

		public AplicacaoDeVacinaDTO(int id, String nomeVacina, LocalDate dataVacina, String emailUsuario) {
			super();
			this.id = id;
			this.nomeVacina = nomeVacina;
			this.dataDeVacina = dataVacina;
			this.emailUsuario = emailUsuario;
		}
		

		public void setId(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
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
			result = prime * result + ((nomeVacina == null) ? 0 : nomeVacina.hashCode());
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
			AplicacaoDeVacinaDTO other = (AplicacaoDeVacinaDTO) obj;
			if (nomeVacina == null) {
				if (other.nomeVacina != null)
					return false;
			} else if (!nomeVacina.equals(other.nomeVacina))
				return false;
			return true;
		}
}

