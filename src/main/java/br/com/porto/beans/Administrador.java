package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Administrador {

	private Long idAdministrador;
	private String numeroFuncionario, descricaoCargo;
	// Chave estrangeira da class usuario
	private Long idUsuario;

	public Administrador() {
		super();
	}

	public Administrador(Long idAdministrador, String numeroFuncionario, String descricaoCargo) {
		super();
		this.idAdministrador = idAdministrador;
		this.numeroFuncionario = numeroFuncionario;
		this.descricaoCargo = descricaoCargo;
	}

	public Administrador(Long idAdministrador, String numeroFuncionario, String descricaoCargo, Long idUsuario) {
		super();
		this.idAdministrador = idAdministrador;
		this.numeroFuncionario = numeroFuncionario;
		this.descricaoCargo = descricaoCargo;
		this.idUsuario = idUsuario;
	}


	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public void setNumeroFuncionario(String numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdAdministrador() {
		return idAdministrador;
	}

	public String getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

}
