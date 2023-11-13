package br.com.porto.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.porto.beans.Apolice;
import br.com.porto.dao.ApoliceDAO;

public class ApoliceBo {

	ApoliceDAO apoliceDAO;

	// selecionar
	public ArrayList<Apolice> selecionarBO() throws ClassNotFoundException, SQLException, ParseException {

		apoliceDAO = new ApoliceDAO();

		return (ArrayList<Apolice>) apoliceDAO.selecionar();

	}

	// inserir
	public void inserirBO(Apolice apolice) throws ClassNotFoundException, SQLException {
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		apoliceDAO.insert(apolice);
	}

	// atualizar
	public void atualizarBO(Apolice apolice) throws ClassNotFoundException, SQLException {
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		apoliceDAO.atualizar(apolice);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		apoliceDAO.deletar(id);
	}
	
}
