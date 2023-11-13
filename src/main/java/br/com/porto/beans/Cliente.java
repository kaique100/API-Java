package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

	private Long idCliente;
	private String estadoCivil, sexo;
	// Chave estrangeira da class usuario
	private Long idUsuario;
	
	public Cliente() {
		super();
	}

	public Cliente(Long idCliente, String estadoCivil, String sexo) {
		super();
		this.idCliente = idCliente;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
	}
	
	public Cliente(Long idCliente, String estadoCivil, String sexo, Long idUsuario) {
		super();
		this.idCliente = idCliente;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.idUsuario = idUsuario;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	
}
