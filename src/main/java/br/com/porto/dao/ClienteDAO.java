package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Cliente;
import br.com.porto.conexoes.ConexaoFactory;

public class ClienteDAO {

	public Connection guinchAppConexao;

	public ClienteDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Cliente cliente) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_CLIENTE values(?,?,?,?)");
		stmt.setLong(1, cliente.getIdCliente());
		stmt.setLong(2, cliente.getIdUsuario());
		stmt.setString(3, cliente.getSexo());
		stmt.setString(4, cliente.getEstadoCivil());
		stmt.execute();
		stmt.close();
		
		return "Cliente cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_CLIENTE WHERE id_cliente = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Cliente Deletado com Sucesso!";
	}

	// Update
	public String atualizar(Cliente cliente) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_CLIENTE set id_usuario = ?, ds_sexo = ?, "
						+ "ds_estado_civil = ? where id_cliente = ?");
		stmt.setLong(1, cliente.getIdUsuario());
		stmt.setString(2, cliente.getSexo());
		stmt.setString(3, cliente.getEstadoCivil());
		stmt.setLong(4, cliente.getIdCliente());
		stmt.executeUpdate();
		stmt.close();

		return "Cliente Atualizado com Sucesso!";
	}

	// Select

	public List<Cliente> selecionar() throws SQLException {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_CLIENTE");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(rs.getLong(1));
			cliente.setIdUsuario(rs.getLong(2));
			cliente.setSexo(rs.getString(3));
			cliente.setEstadoCivil(rs.getString(4));
			listaCliente.add(cliente);
		}

		return listaCliente;

	}
	
}
