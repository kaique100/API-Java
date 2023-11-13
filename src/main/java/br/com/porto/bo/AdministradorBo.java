package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.Administrador;
import br.com.porto.dao.AdministradorDAO;

public class AdministradorBo {

	AdministradorDAO administradorDAO;

	// selecionar
	public ArrayList<Administrador> selecionarBO() throws ClassNotFoundException, SQLException {

		administradorDAO = new AdministradorDAO();

		return (ArrayList<Administrador>) administradorDAO.selecionar();

	}

	// inserir
	public void inserirBO(Administrador administrador) throws ClassNotFoundException, SQLException {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.insert(administrador);
	}

	// atualizar
	public void atualizarBO(Administrador administrador) throws ClassNotFoundException, SQLException {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.atualizar(administrador);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.deletar(id);
	}
	
}
