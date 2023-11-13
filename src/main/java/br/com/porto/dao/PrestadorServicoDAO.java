package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.PrestadorServico;
import br.com.porto.conexoes.ConexaoFactory;

public class PrestadorServicoDAO {

	public Connection guinchAppConexao;

	public PrestadorServicoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(PrestadorServico prestadorServico) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_PRESTADOR_SERVICO values(?,?,?,?,?,?)");
		stmt.setLong(1, prestadorServico.getIdPrestadorServico());
		stmt.setLong(2, prestadorServico.getIdUsuario());
		stmt.setString(3, prestadorServico.getNomePrestadorServico());
		stmt.setString(4, prestadorServico.getDescricaoTipoServico());
		stmt.setString(5, prestadorServico.getDescricaoAreaCoberta());
		stmt.setString(6, prestadorServico.getObservacaoPrestadorServico());
		stmt.execute();
		stmt.close();
		return "Prestador de Serviço cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_PRESTADOR_SERVICO WHERE id_prestador_servico = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Prestador de Serviço Deletado com Sucesso!";
	}

	// Update
	
	public String atualizar(PrestadorServico prestadorServico) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_PRESTADOR_SERVICO set id_usuario = ?, nm_prestador_servico = ?, ds_tipo_servico = ?, "
						+ "ds_area_cobertura = ?, ob_prestador_servico = ? where id_prestador_servico = ?");
		stmt.setLong(1, prestadorServico.getIdUsuario());
		stmt.setString(2, prestadorServico.getNomePrestadorServico());
		stmt.setString(3, prestadorServico.getDescricaoTipoServico());
		stmt.setString(4, prestadorServico.getDescricaoAreaCoberta());
		stmt.setString(5, prestadorServico.getObservacaoPrestadorServico());
		stmt.setLong(6, prestadorServico.getIdPrestadorServico());
		stmt.executeUpdate();
		stmt.close();

		return "Prestador de Serviço Atualizado com Sucesso!";
	}

	// Select

	public List<PrestadorServico> selecionar() throws SQLException {
		List<PrestadorServico> listaPrestadorServico = new ArrayList<PrestadorServico>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_PRESTADOR_SERVICO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			PrestadorServico prestadorServico = new PrestadorServico();
			prestadorServico.setIdPrestadorServico(rs.getLong(1));
			prestadorServico.setIdUsuario(rs.getLong(2));
			prestadorServico.setNomePrestadorServico(rs.getString(3));
			prestadorServico.setDescricaoTipoServico(rs.getString(4));
			prestadorServico.setDescricaoAreaCoberta(rs.getString(5));
			prestadorServico.setObservacaoPrestadorServico(rs.getString(6));
			listaPrestadorServico.add(prestadorServico);
		}

		return listaPrestadorServico;

	}
	
}
