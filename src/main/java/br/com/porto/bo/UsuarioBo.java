package br.com.porto.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.porto.beans.Usuario;
import br.com.porto.dao.UsuarioDAO;

public class UsuarioBo {

	UsuarioDAO usuarioDAO;

	// selecionar
	public ArrayList<Usuario> selecionarBO() throws ClassNotFoundException, SQLException, ParseException {

		usuarioDAO = new UsuarioDAO();

		return (ArrayList<Usuario>) usuarioDAO.selecionar();

	}

	// inserir
	public void inserirBO(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.insert(usuario);
	}

	// atualizar
	public void atualizarBO(Usuario usuario) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.atualizar(usuario);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.deletar(id);
	}
	
}
