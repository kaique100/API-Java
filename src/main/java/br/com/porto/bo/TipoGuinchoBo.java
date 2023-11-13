package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.TipoGuincho;
import br.com.porto.dao.TipoGuinchoDAO;

public class TipoGuinchoBo {

	TipoGuinchoDAO guinchoDAO;

	// selecionar
	public ArrayList<TipoGuincho> selecionarBO() throws ClassNotFoundException, SQLException {

		guinchoDAO = new TipoGuinchoDAO();

		return (ArrayList<TipoGuincho>) guinchoDAO.selecionar();

	}

	// inserir
	public void inserirBO(TipoGuincho tipoGuincho) throws ClassNotFoundException, SQLException {
		TipoGuinchoDAO tipoGuinchoDAO = new TipoGuinchoDAO();
		tipoGuinchoDAO.insert(tipoGuincho);
	}

	// atualizar
	public void atualizarBO(TipoGuincho tipoGuincho) throws ClassNotFoundException, SQLException {
		TipoGuinchoDAO tipoGuinchoDAO = new TipoGuinchoDAO();
		tipoGuinchoDAO.atualizar(tipoGuincho);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		TipoGuinchoDAO tipoGuinchoDAO = new TipoGuinchoDAO();
		tipoGuinchoDAO.deletar(id);
	}
	
	
}
