package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.PrestadorServico;
import br.com.porto.dao.PrestadorServicoDAO;

public class PrestadorServicoBo {

	PrestadorServicoDAO prestadorServicoDAO;

	// selecionar
	public ArrayList<PrestadorServico> selecionarBO() throws ClassNotFoundException, SQLException {

		prestadorServicoDAO = new PrestadorServicoDAO();

		return (ArrayList<PrestadorServico>) prestadorServicoDAO.selecionar();

	}

	// inserir
	public void inserirBO(PrestadorServico prestadorServico) throws ClassNotFoundException, SQLException {
		PrestadorServicoDAO prestadorServicoDAO = new PrestadorServicoDAO();
		prestadorServicoDAO.insert(prestadorServico);
	}

	// atualizar
	public void atualizarBO(PrestadorServico prestadorServico) throws ClassNotFoundException, SQLException {
		PrestadorServicoDAO prestadorServicoDAO = new PrestadorServicoDAO();
		prestadorServicoDAO.atualizar(prestadorServico);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		PrestadorServicoDAO prestadorServicoDAO = new PrestadorServicoDAO();
		prestadorServicoDAO.deletar(id);
	}
	
}
