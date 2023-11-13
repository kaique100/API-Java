package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.dao.CategoriaTarifariaDAO;

public class CategoriaTarifariaBo {

	CategoriaTarifariaDAO categoriaTarifariaDAO;

	// selecionar
	public ArrayList<CategoriaTarifaria> selecionarBO() throws ClassNotFoundException, SQLException {

		categoriaTarifariaDAO = new CategoriaTarifariaDAO();

		return (ArrayList<CategoriaTarifaria>) categoriaTarifariaDAO.selecionar();

	}

	// inserir
	public void inserirBO(CategoriaTarifaria categoriaTarifaria) throws ClassNotFoundException, SQLException {
		CategoriaTarifariaDAO categoriaTarifariaDAO = new CategoriaTarifariaDAO();
		categoriaTarifariaDAO.insert(categoriaTarifaria);
	}

	// atualizar
	public void atualizarBO(CategoriaTarifaria categoriaTarifaria) throws ClassNotFoundException, SQLException {
		CategoriaTarifariaDAO categoriaTarifariaDAO = new CategoriaTarifariaDAO();
		categoriaTarifariaDAO.atualizar(categoriaTarifaria);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		CategoriaTarifariaDAO categoriaTarifariaDAO = new CategoriaTarifariaDAO();
		categoriaTarifariaDAO.deletar(id);
	}
	
}
