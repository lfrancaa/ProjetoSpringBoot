package br.com.skytour.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadePromocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPromocao;

	public Long getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(Long _idPromocao) {
		this.idPromocao = _idPromocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPromocao == null) ? 0 : idPromocao.hashCode());
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
		EntidadePromocao other = (EntidadePromocao) obj;
		if (idPromocao == null) {
			if (other.idPromocao != null)
				return false;
		} else if (!idPromocao.equals(other.idPromocao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getIdPromocao());
	}

}
