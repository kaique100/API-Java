package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Administrador;
import br.com.porto.conexoes.ConexaoFactory;

public class AdministradorDAO {

	public Connection guinchAppConexao;

	public AdministradorDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Administrador administrador) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_ADMINISTRADOR values(?,?,?,?)");
		stmt.setLong(1, administrador.getIdAdministrador());
		stmt.setLong(2, administrador.getIdUsuario());
		stmt.setString(3, administrador.getNumeroFuncionario());
		stmt.setString(4, administrador.getDescricaoCargo());
		stmt.execute();
		stmt.close();
		
		return "Administrador cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_ADMINISTRADOR WHERE id_administrador = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Administrador Deletado com Sucesso!";
	}

	// Update
	public String atualizar(Administrador administrador) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_ADMINISTRADOR set id_usuario = ?, nr_funcionario = ?, "
						+ "ds_cargo = ? where id_administrador = ?");
		stmt.setLong(1, administrador.getIdUsuario());
		stmt.setString(2, administrador.getNumeroFuncionario());
		stmt.setString(3, administrador.getDescricaoCargo());
		stmt.setLong(4, administrador.getIdAdministrador());
		stmt.executeUpdate();
		stmt.close();

		return "Administrador Atualizado com Sucesso!";
	}

	// Select

	public List<Administrador> selecionar() throws SQLException {
		List<Administrador> listaAdministrador = new ArrayList<Administrador>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_ADMINISTRADOR");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Administrador administrador = new Administrador();
			administrador.setIdAdministrador(rs.getLong(1));
			administrador.setIdUsuario(rs.getLong(2));
			administrador.setNumeroFuncionario(rs.getString(3));
			administrador.setDescricaoCargo(rs.getString(4));
			listaAdministrador.add(administrador);
		}

		return listaAdministrador;

	}

}
