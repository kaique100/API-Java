package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.TipoUsuario;
import br.com.porto.conexoes.ConexaoFactory;

public class TipoUsuarioDAO {

	public Connection guinchAppConexao;

	public TipoUsuarioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(TipoUsuario tipoUsuario) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_TIPO_USUARIO values(?,?)");
		stmt.setLong(1, tipoUsuario.getIdTipoUsuario());
		stmt.setString(2, tipoUsuario.getNivelAcesso());
		stmt.execute();
		stmt.close();
		return "Tipo Usuario cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(int id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_TIPO_USUARIO WHERE ID_TIPO_USUARIO = ?");

		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Tipo Usuario Deletado com Sucesso!";
	}

	// Update
	public String atualizar(TipoUsuario tipoUsuario) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_TIPO_USUARIO set ds_nivel_acesso = ? where id_tipo_usuario = ?");
		stmt.setString(1, tipoUsuario.getNivelAcesso());
		stmt.setInt(2, tipoUsuario.getIdTipoUsuario());
		stmt.executeUpdate();
		stmt.close();

		return "Tipo Usuario Atualizado com Sucesso!";
	}

	// Select

	public List<TipoUsuario> selecionar() throws SQLException {
		List<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_TIPO_USUARIO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			TipoUsuario tipoUsuario = new TipoUsuario();
			tipoUsuario.setIdTipoUsuario(rs.getInt(1));
			tipoUsuario.setNivelAcesso(rs.getString(2));
			listaTipoUsuario.add(tipoUsuario);
		}

		return listaTipoUsuario;

	}

}
