package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrestadorServico {
	
	private Long idPrestadorServico;
	private String nomePrestadorServico, descricaoTipoServico, descricaoAreaCoberta, observacaoPrestadorServico;
	// Chave estrangeira da class usuario
	private Long idUsuario;
	
	public PrestadorServico() {
		super();
	}

	public PrestadorServico(Long idPrestadorServico, String nomePrestadorServico, String descricaoTipoServico,
			String descricaoAreaCoberta, String observacaoPrestadorServico) {
		super();
		this.idPrestadorServico = idPrestadorServico;
		this.nomePrestadorServico = nomePrestadorServico;
		this.descricaoTipoServico = descricaoTipoServico;
		this.descricaoAreaCoberta = descricaoAreaCoberta;
		this.observacaoPrestadorServico = observacaoPrestadorServico;
	}

	public PrestadorServico(Long idPrestadorServico, String nomePrestadorServico, String descricaoTipoServico,
			String descricaoAreaCoberta, String observacaoPrestadorServico, Long idUsuario) {
		super();
		this.idPrestadorServico = idPrestadorServico;
		this.nomePrestadorServico = nomePrestadorServico;
		this.descricaoTipoServico = descricaoTipoServico;
		this.descricaoAreaCoberta = descricaoAreaCoberta;
		this.observacaoPrestadorServico = observacaoPrestadorServico;
		this.idUsuario = idUsuario;
	}


	public void setIdPrestadorServico(Long idPrestadorServico) {
		this.idPrestadorServico = idPrestadorServico;
	}

	public void setNomePrestadorServico(String nomePrestadorServico) {
		this.nomePrestadorServico = nomePrestadorServico;
	}

	public void setDescricaoTipoServico(String descricaoTipoServico) {
		this.descricaoTipoServico = descricaoTipoServico;
	}

	public void setDescricaoAreaCoberta(String descricaoAreaCoberta) {
		this.descricaoAreaCoberta = descricaoAreaCoberta;
	}

	public void setObservacaoPrestadorServico(String observacaoPrestadorServico) {
		this.observacaoPrestadorServico = observacaoPrestadorServico;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public long getIdPrestadorServico() {
		return idPrestadorServico;
	}

	public String getNomePrestadorServico() {
		return nomePrestadorServico;
	}

	public String getDescricaoTipoServico() {
		return descricaoTipoServico;
	}

	public String getDescricaoAreaCoberta() {
		return descricaoAreaCoberta;
	}

	public String getObservacaoPrestadorServico() {
		return observacaoPrestadorServico;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	
}
