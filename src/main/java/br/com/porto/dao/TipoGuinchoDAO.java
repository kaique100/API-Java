package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.TipoGuincho;
import br.com.porto.conexoes.ConexaoFactory;

public class TipoGuinchoDAO {

	public Connection guinchAppConexao;

	public TipoGuinchoDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(TipoGuincho tipoGuincho) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_TIPO_GUINCHO values(?,?,?,?,?)");
		stmt.setLong(1, tipoGuincho.getIdTipoGuincho());
		stmt.setString(2, tipoGuincho.getNumeroTipoGuincho());
		stmt.setDouble(3, tipoGuincho.getCapacidadeMaxima());
		stmt.setString(4, tipoGuincho.getRestricao());
		stmt.setString(5, tipoGuincho.getObservacaoTipoGuincho());
		stmt.execute();
		stmt.close();
		
		return "Tipo Guincho Cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_TIPO_GUINCHO WHERE id_tipo_guincho = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Tipo Guincho Deletado com Sucesso!";
	}

	// Update
	public String atualizar(TipoGuincho tipoGuincho) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_TIPO_GUINCHO set nm_tipo_guincho = ?, qt_capacidade_maxima = ?, "
						+ "ds_restricao = ?, ob_tipo_guincho =? where id_tipo_guincho = ?");
		stmt.setString(1, tipoGuincho.getNumeroTipoGuincho());
		stmt.setDouble(2, tipoGuincho.getCapacidadeMaxima());
		stmt.setString(3, tipoGuincho.getRestricao());
		stmt.setString(4, tipoGuincho.getObservacaoTipoGuincho());
		stmt.setLong(5, tipoGuincho.getIdTipoGuincho());
		stmt.executeUpdate();
		stmt.close();

		return "Tipo Guincho Atualizado com Sucesso!";
	}

	// Select

	public List<TipoGuincho> selecionar() throws SQLException {
		List<TipoGuincho> listaTipoGuincho = new ArrayList<TipoGuincho>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_TIPO_GUINCHO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			TipoGuincho tipoGuincho = new TipoGuincho();
			tipoGuincho.setIdTipoGuincho(rs.getLong(1));
			tipoGuincho.setNumeroTipoGuincho(rs.getString(2));
			tipoGuincho.setCapacidadeMaxima(rs.getDouble(3));
			tipoGuincho.setRestricao(rs.getString(4));
			tipoGuincho.setObservacaoTipoGuincho(rs.getString(5));
			listaTipoGuincho.add(tipoGuincho);
		}

		return listaTipoGuincho;

	}
	
}
