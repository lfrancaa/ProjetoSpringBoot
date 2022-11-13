package br.com.skytour.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeVoo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoo;

	public Long getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(Long _idVoo) {
		this.idVoo = _idVoo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVoo == null) ? 0 : idVoo.hashCode());
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
		EntidadeVoo other = (EntidadeVoo) obj;
		if (idVoo == null) {
			if (other.idVoo != null)
				return false;
		} else if (!idVoo.equals(other.idVoo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getIdVoo());
	}

}
