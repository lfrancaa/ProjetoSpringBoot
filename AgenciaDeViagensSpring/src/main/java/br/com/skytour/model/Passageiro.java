package br.com.skytour.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Passageiro extends EntidadePassageiros {
	
	@OneToMany(mappedBy = "passageiro", fetch = FetchType.LAZY)
    private List<Passagem> passagem;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassageiro;

	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 15, unique = true)
	private String rg;

	@Column(nullable = false, length = 15, unique = true)
	private String cpf;

	@Column(nullable = false, name = "dataNascimento")
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

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(nullable = false, length = 15)
	private String telefone;
	
	@Column(nullable = false)
	private String senha;
	
/*	@Column(nullable = false)
    private String userName;
*/
	
/*	@Column(nullable = false)
    private boolean active;
	
	@Column(nullable = false)
    private String roles;
*/
	public Passageiro() {

	}

	public Passageiro(Long _idPassageiro, String _nome, String _rg, String _cpf, LocalDate _dataNascimento,
			String _endereco, String _complemento, String _cep, String _estado, String _email, String _telefone) {

		this.idPassageiro = _idPassageiro;
		this.nome = _nome;
		this.rg = _rg;
		this.cpf = _cpf;
		this.dataNascimento = _dataNascimento;
		this.endereco = _endereco;
		this.complemento = _complemento;
		this.cep = _cep;
		this.estado = _estado;
		this.email = _email;
		this.telefone = _telefone;
	}

	public Long getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(Long _idPassageiro) {
		this.idPassageiro = _idPassageiro;
	}

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

	public List<Passagem> getPassagem() {
        return passagem;
    }

    public void setPassagem(List<Passagem> _passagem) {
        this.passagem = _passagem;
    }
    
    public String getSenha() {
    	return senha;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
/*    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
 
 	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
*/
    

}