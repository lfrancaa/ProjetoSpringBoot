package br.com.skytour.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeHotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long _idHotel) {
		this.idHotel = _idHotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHotel == null) ? 0 : idHotel.hashCode());
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
		EntidadeHotel other = (EntidadeHotel) obj;
		if (idHotel == null) {
			if (other.idHotel != null)
				return false;
		} else if (!idHotel.equals(other.idHotel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getIdHotel());
	}

}
