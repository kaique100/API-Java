package br.com.porto.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ChatBot {
	
	private Long idChatBot;
	private String textoEntrada, textoSaida, descricaoIntencao; 
	private Date dataMensagem;
	// Chave estrangeira da class Cliente
	private Long idCliente;
	// Chave estrangeira da class OrdemServico
	private Long idOrdemServico;
	
	public ChatBot() {
		super();
	}

	public ChatBot(Long idChatBot, String textoEntrada, String textoSaida, String descricaoIntencao,
			String dataMensagem) throws ParseException {
		super();
		this.idChatBot = idChatBot;
		this.textoEntrada = textoEntrada;
		this.textoSaida = textoSaida;
		this.descricaoIntencao = descricaoIntencao;
		this.dataMensagem = new SimpleDateFormat("dd/MM/yyyy").parse(dataMensagem);
	}

	public ChatBot(Long idChatBot, String textoEntrada, String textoSaida, String descricaoIntencao, String dataMensagem,
			Long idCliente, Long idOrdemServico) throws ParseException {
		super();
		this.idChatBot = idChatBot;
		this.textoEntrada = textoEntrada;
		this.textoSaida = textoSaida;
		this.descricaoIntencao = descricaoIntencao;
		this.dataMensagem = new SimpleDateFormat("dd/MM/yyyy").parse(dataMensagem);
		this.idCliente = idCliente;
		this.idOrdemServico = idOrdemServico;
	}


	public void setIdChatBot(Long idChatBot) {
		this.idChatBot = idChatBot;
	}

	public void setTextoEntrada(String textoEntrada) {
		this.textoEntrada = textoEntrada;
	}

	public void setTextoSaida(String textoSaida) {
		this.textoSaida = textoSaida;
	}

	public void setDescricaoIntencao(String descricaoIntencao) {
		this.descricaoIntencao = descricaoIntencao;
	}

	public void setDataMensagem(String dataMensagem) throws ParseException {
		this.dataMensagem = new SimpleDateFormat("dd/MM/yyyy").parse(dataMensagem);
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdOrdemServico(Long idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public Long getIdChatBot() {
		return idChatBot;
	}

	public String getTextoEntrada() {
		return textoEntrada;
	}

	public String getTextoSaida() {
		return textoSaida;
	}

	public String getDescricaoIntencao() {
		return descricaoIntencao;
	}

	public Date getDataMensagem() {
		return dataMensagem;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public Long getIdOrdemServico() {
		return idOrdemServico;
	}

}
