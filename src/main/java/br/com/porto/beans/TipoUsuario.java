package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoUsuario {
	
	private int idTipoUsuario;
	private String nivelAcesso;
	
	public TipoUsuario() {
		super();
	}

	public TipoUsuario(int idTipoUsuario, String nivelAcesso) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nivelAcesso = nivelAcesso;
	}


	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

}
