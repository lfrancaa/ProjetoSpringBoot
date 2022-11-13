package br.com.skytour.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@MappedSuperclass
public abstract class Pessoa extends EntidadePassageiros {

	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 15, unique = true)
	private String rg;

	@Column(nullable = false, length = 15, unique = true)
	private String cpf;

	@Column(nullable = false, name = "data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String complemento;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String estado;

	@Column(nullable = false, length = 80)
	private String email;

	@Column(nullable = false, length = 15)
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String _nome) {
		this.nome = _nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String _rg) {
		this.rg = _rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String _cpf) {
		this.cpf = _cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate _dataNascimento) {
		this.dataNascimento = _dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String _endereco) {
		this.endereco = _endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String _complemento) {
		this.complemento = _complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String _cep) {
		this.cep = _cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String _estado) {
		this.estado = _estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		this.email = _email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String _telefone) {
		this.telefone = _telefone;
	}

}
