
package br.com.skytour.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Passagem extends EntidadePassagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassagem;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String nomeLocalOrigem;

	@Column(nullable = false)
	private String nomeLocalDestino;

	@Column(nullable = false, name = "data_viagem_ida")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataViagemIda;

	@Column(nullable = false, name = "data_viagem_volta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataViagemVolta;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPassageiro_fk", nullable = false)
    private Passageiro passageiro;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDestino_fk", nullable = false)
    private Destino destino;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPromocao_fk", nullable = false)
    private Promocao promocao;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idHotel_fk", nullable = false)
    private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVoo_fk", nullable = false)
    private Voo voo;
	
	
	public Passagem() {

	}

	public Passagem(Long _idPassagem, String _nome,String _nomeLocalOrigem, String _nomeLocalDestino,
			LocalDate _dataViagemIda, LocalDate _dataViagemVolta) {

		this.idPassagem = _idPassagem;
		this.nome = _nome;
		this.nomeLocalOrigem = _nomeLocalOrigem;
		this.nomeLocalDestino = _nomeLocalDestino;
		this.dataViagemIda = _dataViagemIda;
		this.dataViagemVolta = _dataViagemVolta;
	}

	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long _idPassagem) {
		this.idPassagem = _idPassagem;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String _nome) {
		this.nome = _nome;
	}

	public String getNomeLocalOrigem() {
		return nomeLocalOrigem;
	}

	public void setNomeLocalOrigem(String _nomeLocalOrigem) {
		this.nomeLocalOrigem = _nomeLocalOrigem;
	}

	public String getNomeLocalDestino() {
		return nomeLocalDestino;
	}

	public void setNomeLocalDestino(String _nomeLocalDestino) {
		this.nomeLocalDestino = _nomeLocalDestino;
	}

	public LocalDate getDataViagemIda() {
		return dataViagemIda;
	}

	public void setDataViagemIda(LocalDate _dataViagemIda) {
		this.dataViagemIda = _dataViagemIda;
	}

	public LocalDate getDataViagemVolta() {
		return dataViagemVolta;
	}

	public void setDataViagemVolta(LocalDate _dataViagemVolta) {
		this.dataViagemVolta = _dataViagemVolta;
	}

}