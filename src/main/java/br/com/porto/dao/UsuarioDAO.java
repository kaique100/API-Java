package br.com.porto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Usuario;
import br.com.porto.beans.Usuario;
import br.com.porto.conexoes.ConexaoFactory;

public class UsuarioDAO {

	public Connection guinchAppConexao;

	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Usuario usuario) throws SQLException {

		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("INSERT INTO T_GPP_USUARIO values(?,?,?,?,?,?,?,?,?,?)");
		stmt.setLong(1, usuario.getIdUsuario());
		stmt.setLong(2, usuario.getIdEndereco());
		stmt.setLong(3, usuario.getIdTipoUsuario());
		stmt.setString(4, usuario.getNome());
		stmt.setString(5, usuario.getEmail());
		stmt.setString(6, usuario.getCpf());
		String dateFormated = simplesFormat.format(usuario.getDataNascimento());
		stmt.setString(7, dateFormated);
		stmt.setString(8, usuario.getCelular());
		stmt.setString(9, usuario.getSenha());
		dateFormated = simplesFormat.format(usuario.getDataCadastro());
		stmt.setString(10, dateFormated);
		stmt.execute();
		stmt.close();
		return "Usuario cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_USUARIO WHERE id_usuario = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Usuario Deletado com Sucesso!";
	}

	// Update

	public String atualizar(Usuario usuario) throws SQLException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_USUARIO set id_endereco = ?, id_tipo_usuario = ?, nm_usuario = ?, "
						+ "ds_email = ?, nr_cpf = ?, dt_nascimento = ?, tl_celular = ?, "
						+ "senha = ?, dt_cadastro =?  where id_usuario = ?");
		stmt.setLong(1, usuario.getIdEndereco());
		stmt.setLong(2, usuario.getIdTipoUsuario());
		stmt.setString(3, usuario.getNome());
		stmt.setString(4, usuario.getEmail());
		stmt.setString(5, usuario.getCpf());
		String dateFormated = simplesFormat.format(usuario.getDataNascimento());
		stmt.setString(6, dateFormated);
		stmt.setString(7, usuario.getCelular());
		stmt.setString(8, usuario.getSenha());
		dateFormated = simplesFormat.format(usuario.getDataCadastro());
		stmt.setString(9, dateFormated);
		stmt.setLong(10, usuario.getIdEndereco());
		stmt.executeUpdate();
		stmt.close();

		return "Usuario Atualizado com Sucesso!";
	}

	// Select

	public List<Usuario> selecionar() throws SQLException, ParseException {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_USUARIO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getLong(1));
			usuario.setIdEndereco(rs.getLong(2));
			usuario.setIdTipoUsuario(rs.getLong(3));
			usuario.setNome(rs.getString(4));
			usuario.setEmail(rs.getString(5));
			usuario.setCpf(rs.getString(6));
			usuario.setDataNascimento(rs.getString(7));
			usuario.setCelular(rs.getString(8));
			usuario.setSenha(rs.getString(9));
			usuario.setDataCadastro(rs.getString(10));
			listaUsuario.add(usuario);
		}

		return listaUsuario;

	}
}
