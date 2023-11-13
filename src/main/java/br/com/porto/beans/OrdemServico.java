package br.com.porto.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class OrdemServico {
	
	private Long idOrdemServico;
	private Date dataAbertura, dataConclusao;
	private String descricaoServico, statusServico, observacaoServico, descricaoEndereco;
	// Chave estrangeira da class GuinchoPrestadorServico
	private Long idGuinchoPrestadorServico;
	// Chave estrangeira da class
	private Long idVeiculo;
	
	public OrdemServico() {
		super();
	}

	public OrdemServico(Long idOrdemServico, String dataAbertura, String dataConclusao, String descricaoServico,
			String statusServico, String observacaoServico, String descricaoEndereco) throws ParseException {
		super();
		this.idOrdemServico = idOrdemServico;
		this.dataAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(dataAbertura);
		this.dataConclusao = new SimpleDateFormat("dd/MM/yyyy").parse(dataConclusao);
		this.descricaoServico = descricaoServico;
		this.statusServico = statusServico;
		this.observacaoServico = observacaoServico;
		this.descricaoEndereco = descricaoEndereco;
	}

	public OrdemServico(Long idOrdemServico, String dataAbertura, String dataConclusao, String descricaoServico,
			String statusServico, String observacaoServico, String descricaoEndereco, Long idGuinchoPrestadorServico,
			Long idVeiculo) throws ParseException {
		super();
		this.idOrdemServico = idOrdemServico;
		this.dataAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(dataAbertura);
		this.dataConclusao = new SimpleDateFormat("dd/MM/yyyy").parse(dataConclusao);
		this.descricaoServico = descricaoServico;
		this.statusServico = statusServico;
		this.observacaoServico = observacaoServico;
		this.descricaoEndereco = descricaoEndereco;
		this.idGuinchoPrestadorServico = idGuinchoPrestadorServico;
		this.idVeiculo = idVeiculo;
	}


	public void setIdOrdemServico(Long idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public void setDataAbertura(String dataAbertura) throws ParseException {
		this.dataAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(dataAbertura);
	}

	public void setDataConclusao(String dataConclusao) throws ParseException {
		this.dataConclusao = new SimpleDateFormat("dd/MM/yyyy").parse(dataConclusao);
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
	}

	public void setObservacaoServico(String observacaoServico) {
		this.observacaoServico = observacaoServico;
	}

	public void setDescricaoEndereco(String descricaoEndereco) {
		this.descricaoEndereco = descricaoEndereco;
	}

	public void setIdGuinchoPrestadorServico(Long idGuinchoPrestadorServico) {
		this.idGuinchoPrestadorServico = idGuinchoPrestadorServico;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Long getIdOrdemServico() {
		return idOrdemServico;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public String getStatusServico() {
		return statusServico;
	}

	public String getObservacaoServico() {
		return observacaoServico;
	}

	public String getDescricaoEndereco() {
		return descricaoEndereco;
	}

	public Long getIdGuinchoPrestadorServico() {
		return idGuinchoPrestadorServico;
	}

	public long getIdVeiculo() {
		return idVeiculo;
	}
	
}
