package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoGuincho {

	private Long idTipoGuincho;
	private String numeroTipoGuincho, restricao, observacaoTipoGuincho;
	private double capacidadeMaxima;
	
	public TipoGuincho() {
		super();
	}

	public TipoGuincho(Long idTipoGuincho, String numeroTipoGuincho, String restricao, String observacaoTipoGuincho,
			double capacidadeMaxima) {
		super();
		this.idTipoGuincho = idTipoGuincho;
		this.numeroTipoGuincho = numeroTipoGuincho;
		this.restricao = restricao;
		this.observacaoTipoGuincho = observacaoTipoGuincho;
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public long getIdTipoGuincho() {
		return idTipoGuincho;
	}

	public String getNumeroTipoGuincho() {
		return numeroTipoGuincho;
	}

	public String getRestricao() {
		return restricao;
	}

	public String getObservacaoTipoGuincho() {
		return observacaoTipoGuincho;
	}

	public double getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setIdTipoGuincho(Long idTipoGuincho) {
		this.idTipoGuincho = idTipoGuincho;
	}

	public void setNumeroTipoGuincho(String numeroTipoGuincho) {
		this.numeroTipoGuincho = numeroTipoGuincho;
	}

	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}

	public void setObservacaoTipoGuincho(String observacaoTipoGuincho) {
		this.observacaoTipoGuincho = observacaoTipoGuincho;
	}

	public void setCapacidadeMaxima(double capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	
	
	
}
