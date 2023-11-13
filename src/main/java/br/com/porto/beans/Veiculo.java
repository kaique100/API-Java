package br.com.porto.beans;

import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import java.text.SimpleDateFormat;
@XmlRootElement
public class Veiculo {
	
	private Long idVeiculo;
	private String marca, modelo, chassi, placa, cor, combustivel, transmissao;
	private Date fabricacao;
	private double quilometragem;
	// Chave estrangeira da class Cliente
	private Long idCliente;
	// Chave estrangeira da class CategoriaTarifaria
	private Long idCategoriaTarifaria;
	
	public Veiculo() {
		super();
	}

	public Veiculo(Long idVeiculo, String marca, String modelo, String chassi, String placa, String cor,
			String combustivel, String transmissao, String fabricacao, double quilometragem)throws ParseException {
		super();
		this.idVeiculo = idVeiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.placa = placa;
		this.cor = cor;
		this.combustivel = combustivel;
		this.transmissao = transmissao;
		this.fabricacao = new SimpleDateFormat("dd/MM/yyyy").parse(fabricacao);
		this.quilometragem = quilometragem;
	}

	public Veiculo(Long idVeiculo, String marca, String modelo, String chassi, String placa, String cor,
			String combustivel, String transmissao, String fabricacao, double quilometragem, Long idCliente,
			Long idCategoriaTarifaria) throws ParseException{
		super();
		this.idVeiculo = idVeiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.placa = placa;
		this.cor = cor;
		this.combustivel = combustivel;
		this.transmissao = transmissao;
		this.fabricacao = new SimpleDateFormat("dd/MM/yyyy").parse(fabricacao);
		this.quilometragem = quilometragem;
		this.idCliente = idCliente;
		this.idCategoriaTarifaria = idCategoriaTarifaria;
	}


	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public void setTransmissao(String transmissao) {
		this.transmissao = transmissao;
	}

	public void setFabricacao(String fabricacao) throws ParseException {
		this.fabricacao = new SimpleDateFormat("dd/MM/yyyy").parse(fabricacao);
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdCategoriaTarifaria(Long idCategoriaTarifaria) {
		this.idCategoriaTarifaria = idCategoriaTarifaria;
	}

	public long getIdVeiculo() {
		return idVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCor() {
		return cor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public String getTransmissao() {
		return transmissao;
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public Long getIdCategoriaTarifaria() {
		return idCategoriaTarifaria;
	}
	
}
