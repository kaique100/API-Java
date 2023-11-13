package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Guincho {
	
	private Long idGuincho;
	private String placa, descricaoGuincho, observacaoGuincho;
	private boolean disponibilidade;
	// Chave estrangeira da class TipoGuincho
	private Long idTipoGuincho;
	
	public Guincho() {
		super();
	}

	public Guincho(Long idGuincho, String placa, String descricaoGuincho, String observacaoGuincho,
			boolean disponibilidade) {
		super();
		this.idGuincho = idGuincho;
		this.placa = placa;
		this.descricaoGuincho = descricaoGuincho;
		this.observacaoGuincho = observacaoGuincho;
		this.disponibilidade = disponibilidade;
	}

	public Guincho(Long idGuincho, String placa, String descricaoGuincho, String observacaoGuincho,
			Boolean disponibilidade, Long idTipoGuincho) {
		super();
		this.idGuincho = idGuincho;
		this.placa = placa;
		this.descricaoGuincho = descricaoGuincho;
		this.observacaoGuincho = observacaoGuincho;
		this.disponibilidade = disponibilidade;
		this.idTipoGuincho = idTipoGuincho;
	}


	public void setIdGuincho(Long idGuincho) {
		this.idGuincho = idGuincho;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setDescricaoGuincho(String descricaoGuincho) {
		this.descricaoGuincho = descricaoGuincho;
	}

	public void setObservacaoGuincho(String observacaoGuincho) {
		this.observacaoGuincho = observacaoGuincho;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public void setIdTipoGuincho(Long idTipoGuincho) {
		this.idTipoGuincho = idTipoGuincho;
	}
	
	public long getIdGuincho() {
		return idGuincho;
	}

	public String getPlaca() {
		return placa;
	}

	public String getDescricaoGuincho() {
		return descricaoGuincho;
	}

	public String getObservacaoGuincho() {
		return observacaoGuincho;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public Long getIdTipoGuincho() {
		return idTipoGuincho;
	}

}
