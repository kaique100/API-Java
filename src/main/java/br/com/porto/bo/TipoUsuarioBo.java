package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.TipoUsuario;
import br.com.porto.dao.TipoUsuarioDAO;

public class TipoUsuarioBo {

	TipoUsuarioDAO tipoUsuarioDAO;

	// selecionar
	public ArrayList<TipoUsuario> selecionarBO() throws ClassNotFoundException, SQLException {

		tipoUsuarioDAO = new TipoUsuarioDAO();

		return (ArrayList<TipoUsuario>) tipoUsuarioDAO.selecionar();

	}

	// inserir
	public void inserirBO(TipoUsuario tipoUsuario) throws ClassNotFoundException, SQLException {
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		tipoUsuarioDAO.insert(tipoUsuario);
	}

	// atualizar
	public void atualizarBO(TipoUsuario tipoUsuario) throws ClassNotFoundException, SQLException {
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		tipoUsuarioDAO.atualizar(tipoUsuario);
	}

	// deletar
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		tipoUsuarioDAO.deletar(id);
	}

}
