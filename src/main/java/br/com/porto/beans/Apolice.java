package br.com.porto.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Apolice {

	private Long idApolice;
	private String numeroApolice, numeroEndosso, numeroProposta, descricaoApolice;
	private Date dataInicioVigente, dataFinalVigente;
	private double valorPremioTotal;
	private Long idVeiculo;
	
	public Apolice() {
		super();
	}

	public Apolice(Long idApolice, String numeroApolice, String numeroEndosso, String numeroProposta,
			String descricaoApolice, String dataInicioVigente, String dataFinalVigente, double valorPremioTotal) throws ParseException {
		super();
		this.idApolice = idApolice;
		this.numeroApolice = numeroApolice;
		this.numeroEndosso = numeroEndosso;
		this.numeroProposta = numeroProposta;
		this.descricaoApolice = descricaoApolice;
		this.dataInicioVigente = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioVigente);
		this.dataFinalVigente = new SimpleDateFormat("dd/MM/yyyy").parse(dataFinalVigente);
		this.valorPremioTotal = valorPremioTotal;
	}
	
	


	public Apolice(Long idApolice, String numeroApolice, String numeroEndosso, String numeroProposta,
			String descricaoApolice, String dataInicioVigente, String dataFinalVigente, double valorPremioTotal,
			Long idVeiculo) throws ParseException {
		super();
		this.idApolice = idApolice;
		this.numeroApolice = numeroApolice;
		this.numeroEndosso = numeroEndosso;
		this.numeroProposta = numeroProposta;
		this.descricaoApolice = descricaoApolice;
		this.dataInicioVigente = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioVigente);
		this.dataFinalVigente = new SimpleDateFormat("dd/MM/yyyy").parse(dataFinalVigente);
		this.valorPremioTotal = valorPremioTotal;
		this.idVeiculo = idVeiculo;
	}

	public void setIdApolice(Long idApolice) {
		this.idApolice = idApolice;
	}

	public void setNumeroApolice(String numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public void setNumeroEndosso(String numeroEndosso) {
		this.numeroEndosso = numeroEndosso;
	}

	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	public void setDescricaoApolice(String descricaoApolice) {
		this.descricaoApolice = descricaoApolice;
	}

	public void setDataInicioVigente(String dataInicioVigente) throws ParseException {
		this.dataInicioVigente = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioVigente);
	}

	public void setDataFinalVigente(String dataFinalVigente) throws ParseException {
		this.dataFinalVigente =new SimpleDateFormat("dd/MM/yyyy").parse(dataFinalVigente);
	}

	public void setValorPremioTotal(double valorPremioTotal) {
		this.valorPremioTotal = valorPremioTotal;
	}
	
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public long getIdApolice() {
		return idApolice;
	}

	public String getNumeroApolice() {
		return numeroApolice;
	}

	public String getNumeroEndosso() {
		return numeroEndosso;
	}

	public String getNumeroProposta() {
		return numeroProposta;
	}

	public String getDescricaoApolice() {
		return descricaoApolice;
	}

	public Date getDataInicioVigente() {
		return dataInicioVigente;
	}

	public Date getDataFinalVigente() {
		return dataFinalVigente;
	}

	public double getValorPremioTotal() {
		return valorPremioTotal;
	}

	public long getIdVeiculo() {
		return idVeiculo;
	}
	
}
