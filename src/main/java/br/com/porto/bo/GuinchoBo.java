package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.Guincho;
import br.com.porto.dao.GuinchoDAO;

public class GuinchoBo {

	GuinchoDAO guinchoDAO;

	// selecionar
	public ArrayList<Guincho> selecionarBO() throws ClassNotFoundException, SQLException {

		guinchoDAO = new GuinchoDAO();

		return (ArrayList<Guincho>) guinchoDAO.selecionar();

	}

	// inserir
	public void inserirBO(Guincho guincho) throws ClassNotFoundException, SQLException {
		GuinchoDAO guinchoDAO = new GuinchoDAO();
		guinchoDAO.insert(guincho);
	}

	// atualizar
	public void atualizarBO(Guincho guincho) throws ClassNotFoundException, SQLException {
		GuinchoDAO guinchoDAO = new GuinchoDAO();
		guinchoDAO.atualizar(guincho);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		GuinchoDAO guinchoDAO = new GuinchoDAO();
		guinchoDAO.deletar(id);
	}
	
}
