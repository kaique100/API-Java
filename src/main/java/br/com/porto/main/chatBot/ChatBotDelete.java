package br.com.porto.main.chatBot;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.ChatBot;
import br.com.porto.dao.ChatBotDAO;

public class ChatBotDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ChatBotDAO dao = new ChatBotDAO();
		ChatBot objChatBot = new ChatBot();
		
		objChatBot.setIdChatBot(id("Digite o codigo do ChatBot a ser deletado: "));
		System.out.println(dao.deletar(objChatBot.getIdChatBot()));

	}

}
