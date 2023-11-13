package br.com.porto.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.porto.beans.ChatBot;
import br.com.porto.dao.ChatBotDAO;

public class ChatBotBo {
	
	ChatBotDAO chatBotDAO;

	// selecionar
	public ArrayList<ChatBot> selecionarBO() throws ClassNotFoundException, SQLException, ParseException {

		chatBotDAO = new ChatBotDAO();

		return (ArrayList<ChatBot>) chatBotDAO.selecionar();

	}

	// inserir
	public void inserirBO(ChatBot chatBot) throws ClassNotFoundException, SQLException {
		ChatBotDAO chatBotDAO = new ChatBotDAO();
		chatBotDAO.insert(chatBot);
	}

	// atualizar
	public void atualizarBO(ChatBot chatBot) throws ClassNotFoundException, SQLException {
		ChatBotDAO chatBotDAO = new ChatBotDAO();
		chatBotDAO.atualizar(chatBot);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		ChatBotDAO chatBotDAO = new ChatBotDAO();
		chatBotDAO.deletar(id);
	}
	
}
