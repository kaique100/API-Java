package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GuinchoPrestadorServico {

	private Long idGuinchoPrestadorServico;
	private String descricaoLocalizacaoAtual;
	// Chave estrangeira da class PrestadorServico
	private Long idPrestadorServico;
	// Chave estrangeira da class Guincho
	private Long idGuincho;
	
	public GuinchoPrestadorServico() {
		super();
	}

	public GuinchoPrestadorServico(Long idGuinchoPrestadorServico, String descricaoLocalizacaoAtual) {
		super();
		this.idGuinchoPrestadorServico = idGuinchoPrestadorServico;
		this.descricaoLocalizacaoAtual = descricaoLocalizacaoAtual;
	}

	public GuinchoPrestadorServico(Long idGuinchoPrestadorServico, String descricaoLocalizacaoAtual, Long idPrestadorServico,
			Long idGuincho) {
		super();
		this.idGuinchoPrestadorServico = idGuinchoPrestadorServico;
		this.descricaoLocalizacaoAtual = descricaoLocalizacaoAtual;
		this.idPrestadorServico = idPrestadorServico;
		this.idGuincho = idGuincho;
	}


	public void setIdGuinchoPrestadorServico(Long idGuinchoPrestadorServico) {
		this.idGuinchoPrestadorServico = idGuinchoPrestadorServico;
	}

	public void setDescricaoLocalizacaoAtual(String descricaoLocalizacaoAtual) {
		this.descricaoLocalizacaoAtual = descricaoLocalizacaoAtual;
	}

	public void setIdPrestadorServico(Long idPrestadorServico) {
		this.idPrestadorServico = idPrestadorServico;
	}

	public void setIdGuincho(Long idGuincho) {
		this.idGuincho = idGuincho;
	}

	public Long getIdGuinchoPrestadorServico() {
		return idGuinchoPrestadorServico;
	}

	public String getDescricaoLocalizacaoAtual() {
		return descricaoLocalizacaoAtual;
	}

	public Long getIdPrestadorServico() {
		return idPrestadorServico;
	}

	public Long getIdGuincho() {
		return idGuincho;
	}
	
}
