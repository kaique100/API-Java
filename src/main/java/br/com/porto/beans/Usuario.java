package br.com.porto.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Usuario {
	
	private Long idUsuario;
	private String nome, email, cpf, celular, senha;
	private Date dataNascimento, dataCadastro;
	// Chave estrangeira da class usuario
	private Long idTipoUsuario;
	private Long idEndereco;
	
	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nome, String email, String cpf, String celular, String senha,
			String dataNascimento, String dataCadastro) throws ParseException {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.celular = celular;
		this.senha = senha;
		this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		this.dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(dataCadastro);
	}

	public Usuario(Long idUsuario, String nome, String email, String cpf, String celular, String senha,
			String dataNascimento, String dataCadastro, Long idTipoUsuario, Long idEndereco) throws ParseException {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.celular = celular;
		this.senha = senha;
		this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		this.dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(dataCadastro);
		this.idTipoUsuario = idTipoUsuario;
		this.idEndereco = idEndereco;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public void setDataNascimento(String dataNascimento) throws ParseException {
		this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
	}

	public void setDataCadastro(String dataCadastro) throws ParseException {
		this.dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(dataCadastro);
	}

	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCelular() {
		return celular;
	}

	public String getSenha() {
		return senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}
	
	public Long getIdEndereco() {
		return idEndereco;
	}
	
}
