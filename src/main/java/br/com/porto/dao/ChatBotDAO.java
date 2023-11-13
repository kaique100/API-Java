package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.ChatBot;
import br.com.porto.conexoes.ConexaoFactory;

public class ChatBotDAO {

	public Connection guinchAppConexao;

	public ChatBotDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(ChatBot chatBot) throws SQLException {

		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_CHATBOT values(?,?,?,?,?,?,?)");
		stmt.setLong(1, chatBot.getIdChatBot());
		stmt.setLong(2, chatBot.getIdOrdemServico());
		stmt.setLong(3, chatBot.getIdCliente());
		stmt.setString(4, chatBot.getTextoEntrada());
		stmt.setString(5, chatBot.getTextoSaida());
		String dateFormated = simplesFormat.format(chatBot.getDataMensagem());
		stmt.setString(6, dateFormated);
		stmt.setString(7, chatBot.getDescricaoIntencao());
		stmt.execute();
		stmt.close();
		return "ChatBot cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_CHATBOT WHERE id_chatbot = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "ChatBot Deletado com Sucesso!";
	}

	// Update
	
	public String atualizar(ChatBot chatBot) throws SQLException {
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_CHATBOT set id_ordem_servico = ?, id_cliente = ?, tx_entrada = ?, "
						+ "tx_saida = ?, dt_mensagem = ?, ds_intencao = ? where id_chatbot = ?");
		stmt.setLong(1, chatBot.getIdOrdemServico());
		stmt.setLong(2, chatBot.getIdCliente());
		stmt.setString(3, chatBot.getTextoEntrada());
		stmt.setString(4, chatBot.getTextoSaida());
		String dateFormated = simplesFormat.format(chatBot.getDataMensagem());
		stmt.setString(5, dateFormated);
		stmt.setString(6, chatBot.getDescricaoIntencao());
		stmt.setLong(7, chatBot.getIdChatBot());
		stmt.executeUpdate();
		stmt.close();

		return "ChatBot Atualizado com Sucesso!";
	}

	// Select

	public List<ChatBot> selecionar() throws SQLException, ParseException {
		List<ChatBot> listaChatBot = new ArrayList<ChatBot>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_CHATBOT");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ChatBot chatBot = new ChatBot();
			chatBot.setIdChatBot(rs.getLong(1));
			chatBot.setIdOrdemServico(rs.getLong(2));
			chatBot.setIdCliente(rs.getLong(3));
			chatBot.setTextoEntrada(rs.getString(4));
			chatBot.setTextoSaida(rs.getString(5));
			chatBot.setDataMensagem(rs.getString(6));
			chatBot.setDescricaoIntencao(rs.getString(7));
			listaChatBot.add(chatBot);
		}

		return listaChatBot;

	}
	
}
