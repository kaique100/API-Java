package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.Cliente;
import br.com.porto.dao.ClienteDAO;

public class ClienteBo {

	ClienteDAO clienteDAO;

	// selecionar
	public ArrayList<Cliente> selecionarBO() throws ClassNotFoundException, SQLException {

		clienteDAO = new ClienteDAO();

		return (ArrayList<Cliente>) clienteDAO.selecionar();

	}

	// inserir
	public void inserirBO(Cliente cliente) throws ClassNotFoundException, SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.insert(cliente);
	}

	// atualizar
	public void atualizarBO(Cliente cliente) throws ClassNotFoundException, SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.atualizar(cliente);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deletar(id);
	}
	
}
