package br.com.skytour.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadePassagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassagem;

	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long _idPassagem) {
		this.idPassagem = _idPassagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassagem == null) ? 0 : idPassagem.hashCode());
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
		EntidadePassagem other = (EntidadePassagem) obj;
		if (idPassagem == null) {
			if (other.idPassagem != null)
				return false;
		} else if (!idPassagem.equals(other.idPassagem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getIdPassagem());
	}

}
