package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Endereco;
import br.com.porto.beans.Endereco;
import br.com.porto.conexoes.ConexaoFactory;

public class EnderecoDAO {

	public Connection guinchAppConexao;

	public EnderecoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Endereco endereco) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_ENDERECO values(?,?,?,?,?,?)");
		stmt.setLong(1, endereco.getIdEndereco());
		stmt.setString(2, endereco.getLogradouro());
		stmt.setString(3, endereco.getCep());
		stmt.setString(4, endereco.getCidade());
		stmt.setString(5, endereco.getEstado());
		stmt.setString(6, endereco.getBairro());
		stmt.execute();
		stmt.close();
		return "Endereço cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_ENDERECO WHERE id_endereco = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Endereço Deletado com Sucesso!";
	}

	// Update
	
	public String atualizar(Endereco endereco) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_ENDERECO set logradouro = ?, cep = ?, cidade = ?, "
						+ "estado = ?, bairro = ? where id_endereco = ?");
		stmt.setString(1, endereco.getLogradouro());
		stmt.setString(2, endereco.getCep());
		stmt.setString(3, endereco.getCidade());
		stmt.setString(4, endereco.getEstado());
		stmt.setString(5, endereco.getBairro());
		stmt.setLong(6, endereco.getIdEndereco());
		stmt.executeUpdate();
		stmt.close();

		return "Endereço Atualizado com Sucesso!";
	}

	// Select

	public List<Endereco> selecionar() throws SQLException {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_ENDERECO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(rs.getLong(1));
			endereco.setLogradouro(rs.getString(2));
			endereco.setCep(rs.getString(3));
			endereco.setCidade(rs.getString(4));
			endereco.setEstado(rs.getString(5));
			endereco.setBairro(rs.getString(6));
			listaEndereco.add(endereco);
		}

		return listaEndereco;

	}
}
