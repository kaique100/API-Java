package br.com.porto.main.chatBot;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.ChatBot;
import br.com.porto.dao.ChatBotDAO;

public class ChatBotSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		ChatBotDAO da = new ChatBotDAO();

		List<ChatBot> listaChatBot = (ArrayList<ChatBot>) da.selecionar();

		if (listaChatBot != null) {
			for (ChatBot chatBot : listaChatBot) {
				System.out.println(
						chatBot.getIdChatBot() + " " + chatBot.getIdCliente() + " " + chatBot.getIdOrdemServico() + " " 
						+ chatBot.getTextoEntrada() + " " + chatBot.getTextoSaida() + " " + chatBot.getDescricaoIntencao() 
						+ " " + chatBot.getDataMensagem()
						);
			}
		}

	}

}
