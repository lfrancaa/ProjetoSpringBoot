package br.com.skytour.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeDestino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestino;

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long _idDestino) {
		this.idDestino = _idDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDestino == null) ? 0 : idDestino.hashCode());
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
		EntidadeDestino other = (EntidadeDestino) obj;
		if (idDestino == null) {
			if (other.idDestino != null)
				return false;
		} else if (!idDestino.equals(other.idDestino))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getIdDestino());
	}

}
