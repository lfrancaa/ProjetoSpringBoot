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
public class Promocao extends EntidadePromocao {
	
	@OneToMany(mappedBy = "promocao", fetch = FetchType.LAZY)
    private List<Passagem> passagem;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPromocao;

	@Column(nullable = false)
	private String localViagem;
	
	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal valorViagem;

	@Lob
	private byte[] imagem;

	public Promocao() {

	}

	public Promocao(Long _idPromocao, String _localViagem, String _descricao, BigDecimal _valorViagem) {

		this.idPromocao = _idPromocao;
		this.localViagem = _localViagem;
		this.descricao = _descricao;
		this.valorViagem = _valorViagem;
	}

	public Long getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(Long _idPromocao) {
		this.idPromocao = _idPromocao;
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