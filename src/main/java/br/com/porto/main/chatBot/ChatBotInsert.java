package br.com.porto.main.chatBot;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.com.porto.beans.ChatBot;
import br.com.porto.dao.ChatBotDAO;

public class ChatBotInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		ChatBotDAO dao = new ChatBotDAO();
		ChatBot objChatBot = new ChatBot();
		
		objChatBot.setIdChatBot(id("Digite o ID do ChatBot: "));
		objChatBot.setIdCliente(id("Digite o ID do Cliente: "));
		objChatBot.setIdOrdemServico(id("Diigte o ID da Ordem Serviço: "));
		objChatBot.setTextoEntrada(texto("Digite o texto de entreda: "));
		objChatBot.setTextoSaida(texto("Digite o texto de saida: "));
		objChatBot.setDataMensagem(texto("Digite a data da mensagem (dd/mm/yyyy): "));
		objChatBot.setDescricaoIntencao(texto("Digite a descrição da intenção do ChatBot: "));
		
		System.out.println(dao.insert(objChatBot));

	}

}
