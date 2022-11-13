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
public class Destino extends EntidadeDestino {
	
	@OneToMany(mappedBy = "destino", fetch = FetchType.LAZY)
    private List<Passagem> passagem;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestino;

	@Column(nullable = false)
	private String localViagem;
	
	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal valorViagem;

	@Lob
	private byte[] imagem;

	public Destino() {

	}

	public Destino(Long _idDestino, String _localViagem, String _descricao, BigDecimal _valorViagem) {

		this.idDestino = _idDestino;
		this.localViagem = _localViagem;
		this.descricao = _descricao;
		this.valorViagem = _valorViagem;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long _idDestino) {
		this.idDestino = _idDestino;
	}

	public String getLocalViagem() {
		return localViagem;
	}

	public void setLocalViagem(String _localViagem) {
		this.localViagem = _localViagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}

	public BigDecimal getValorViagem() {
		return valorViagem;
	}

	public void setValorViagem(BigDecimal _valorViagem) {
		this.valorViagem = _valorViagem;
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