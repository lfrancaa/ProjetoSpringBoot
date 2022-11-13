package br.com.skytour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table
public class Voo extends EntidadeVoo {
	
	@OneToMany(mappedBy = "voo", fetch = FetchType.LAZY)
    private List<Passagem> passagem;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoo;

	@Column(nullable = false)
	private String origem;

	@Column(nullable = false)
	private String destino;

	@Column(nullable = false, name = "partida")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate partida;

	@Column(nullable = false, name = "chegada")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate chegada;

	@Column(nullable = false)
	private int paradas;
	
	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal valorVoo;
	
	@Lob
	private byte[] imagem;
	
	public Voo() {

	}

	public Voo(Long _idVoo,  String _origem, String _destino, LocalDate _partida,
			LocalDate _chegada, int _paradas, BigDecimal _valorVoo) {

		this.idVoo = _idVoo;
		
		this.origem = _origem;
		this.destino = _destino;
		this.partida = _partida;
		this.chegada = _chegada;
		this.paradas = _paradas;
		this.valorVoo = _valorVoo;
	}

	public Long getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(Long _idVoo) {
		this.idVoo = _idVoo;
	}

	

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String _origem) {
		this.origem = _origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String _destino) {
		this.destino = _destino;
	}

	public LocalDate getPartida() {
		return partida;
	}

	public void setPartida(LocalDate _partida) {
		this.partida = _partida;
	}

	public LocalDate getChegada() {
		return chegada;
	}

	public void setChegada(LocalDate _chegada) {
		this.chegada = _chegada;
	}

	public int getParadas() {
		return paradas;
	}

	public void setParadas(int _paradas) {
		this.paradas = _paradas;
	}
	
	
	public BigDecimal getValorVoo() {
		return valorVoo;
	}

	public void setValorVoo(BigDecimal _valorVoo) {
		this.valorVoo = _valorVoo;
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