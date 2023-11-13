package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.conexoes.ConexaoFactory;

public class GuinchoPrestadorServicoDAO {

	public Connection guinchAppConexao;

	public GuinchoPrestadorServicoDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(GuinchoPrestadorServico guinchoPrestadorServico) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_GUINCHO_PRESTADOR_SERVICO values(?,?,?,?)");
		stmt.setLong(1, guinchoPrestadorServico.getIdGuinchoPrestadorServico());
		stmt.setLong(2, guinchoPrestadorServico.getIdGuincho());
		stmt.setLong(3, guinchoPrestadorServico.getIdPrestadorServico());
		stmt.setString(4, guinchoPrestadorServico.getDescricaoLocalizacaoAtual());
		stmt.execute();
		stmt.close();
		
		return "Guincho Prestador Serviço cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_GUINCHO_PRESTADOR_SERVICO WHERE id_guincho_prestador_servico = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Guincho Prestador Serviço Deletado com Sucesso!";
	}

	// Update
	public String atualizar(GuinchoPrestadorServico guinchoPrestadorServico) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_GUINCHO_PRESTADOR_SERVICO set id_guincho = ?, id_prestador_servico = ?, "
						+ "ds_localizacao_atual = ? where id_guincho_prestador_servico = ?");
		stmt.setLong(1, guinchoPrestadorServico.getIdGuincho());
		stmt.setLong(2, guinchoPrestadorServico.getIdPrestadorServico());
		stmt.setString(3, guinchoPrestadorServico.getDescricaoLocalizacaoAtual());
		stmt.setLong(4, guinchoPrestadorServico.getIdGuinchoPrestadorServico());
		stmt.executeUpdate();
		stmt.close();

		return "Guincho Prestador Serviço Atualizado com Sucesso!";
	}

	// Select

	public List<GuinchoPrestadorServico> selecionar() throws SQLException {
		List<GuinchoPrestadorServico> listaGuinchoPrestadorServico = new ArrayList<GuinchoPrestadorServico>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_GUINCHO_PRESTADOR_SERVICO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			GuinchoPrestadorServico guinchoPrestadorServico = new GuinchoPrestadorServico();
			guinchoPrestadorServico.setIdGuinchoPrestadorServico(rs.getLong(1));
			guinchoPrestadorServico.setIdGuincho(rs.getLong(2));
			guinchoPrestadorServico.setIdPrestadorServico(rs.getLong(3));
			guinchoPrestadorServico.setDescricaoLocalizacaoAtual(rs.getString(4));
			listaGuinchoPrestadorServico.add(guinchoPrestadorServico);
		}

		return listaGuinchoPrestadorServico;

	}
	
}
