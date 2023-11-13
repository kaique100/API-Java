package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.Endereco;
import br.com.porto.dao.EnderecoDAO;

public class EnderecoBo {

	EnderecoDAO enderecoDAO;

	// selecionar
	public ArrayList<Endereco> selecionarBO() throws ClassNotFoundException, SQLException {

		enderecoDAO = new EnderecoDAO();

		return (ArrayList<Endereco>) enderecoDAO.selecionar();

	}

	// inserir
	public void inserirBO(Endereco endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.insert(endereco);
	}

	// atualizar
	public void atualizarBO(Endereco endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.atualizar(endereco);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.deletar(id);
	}

}
