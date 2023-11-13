package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco {

	private Long idEndereco;
	private String logradouro, estado, cep, bairro, cidade;
	
	public Endereco() {
		super();
	}

	public Endereco(Long idEndereco, String logradouro, String estado, String cep, String bairro, String cidade) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.estado = estado;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	
}
