package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoriaTarifaria {

	private Long idCategoriaTarifaria;
	private String numeroCategoriaTarifaria;
	private double valorBase, valorPesoMaximo;
	
	public CategoriaTarifaria() {
		super();
	}

	public CategoriaTarifaria(Long idCategoriaTarifaria, String numeroCategoriaTarifaria, double valorBase, double valorPesoMaximo) {
		super();
		this.idCategoriaTarifaria = idCategoriaTarifaria;
		this.numeroCategoriaTarifaria = numeroCategoriaTarifaria;
		this.valorBase = valorBase;
		this.valorPesoMaximo = valorPesoMaximo;
	}


	public void setIdCategoriaTarifaria(Long idCategoriaTarifaria) {
		this.idCategoriaTarifaria = idCategoriaTarifaria;
	}

	public void setNumeroCategoriaTarifaria(String numeroCategoriaTarifaria) {
		this.numeroCategoriaTarifaria = numeroCategoriaTarifaria;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}

	public void setValorPesoMaximo(double valorPesoMaximo) {
		this.valorPesoMaximo = valorPesoMaximo;
	}
	
	public long getIdCategoriaTarifaria() {
		return idCategoriaTarifaria;
	}

	public String getNumeroCategoriaTarifaria() {
		return numeroCategoriaTarifaria;
	}

	public double getValorBase() {
		return valorBase;
	}

	public double getValorPesoMaximo() {
		return valorPesoMaximo;
	}
	
	public double CalcularCategoriaTarifaria(double valorBase, double valorPesoMaximo) {
		return valorBase*valorPesoMaximo;
	}
	
}
