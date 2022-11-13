package br.com.skytour.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table
public class Hotel extends EntidadeHotel {
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Passagem> passagem;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	
	@Column(nullable = false)
	private String localHotel;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal valorHospedagem;
	
	@Lob
	private byte[] imagem;
	
	public Hotel() {

	}

	public Hotel(Long _idHotel, String _localHotel, String _descricao, BigDecimal _valorHospedagem) {

		this.idHotel = _idHotel;
		this.localHotel = _localHotel;
		this.descricao = _descricao;
		this.valorHospedagem = _valorHospedagem;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long _idHotel) {
		this.idHotel = _idHotel;
	}

	public String getLocalHotel() {
		return localHotel;
	}

	public void setLocalHotel(String _localHotel) {
		this.localHotel = _localHotel;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}
	
	public BigDecimal getValorHospedagem() {
		return valorHospedagem;
	}

	public void setValorHospedagem(BigDecimal _valorHospedagem) {
		this.valorHospedagem = _valorHospedagem;
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public List<Passagem> getPassagem() {
        return passagem;
    }

    public void setPassagem(List<Passagem> _passagem) {
        this.passagem = _passagem;
    }
}