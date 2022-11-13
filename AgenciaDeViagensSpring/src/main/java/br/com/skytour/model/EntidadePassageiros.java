package br.com.skytour.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadePassageiros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassageiro;

	public Long getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(Long _idPassageiro) {
		this.idPassageiro = _idPassageiro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassageiro == null) ? 0 : idPassageiro.hashCode());
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
		EntidadePassageiros other = (EntidadePassageiros) obj;
		if (idPassageiro == null) {
			if (other.idPassageiro != null)
				return false;
		} else if (!idPassageiro.equals(other.idPassageiro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getIdPassageiro());
	}

}
