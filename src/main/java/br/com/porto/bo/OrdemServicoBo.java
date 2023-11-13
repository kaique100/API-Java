package br.com.porto.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.porto.beans.OrdemServico;
import br.com.porto.dao.OrdemServicoDAO;

public class OrdemServicoBo {

	OrdemServicoDAO ordemServicoDAO;

	// selecionar
	public ArrayList<OrdemServico> selecionarBO() throws ClassNotFoundException, SQLException, ParseException {

		ordemServicoDAO = new OrdemServicoDAO();

		return (ArrayList<OrdemServico>) ordemServicoDAO.selecionar();

	}

	// inserir
	public void inserirBO(OrdemServico ordemServico) throws ClassNotFoundException, SQLException {
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
		ordemServicoDAO.insert(ordemServico);
	}

	// atualizar
	public void atualizarBO(OrdemServico ordemServico) throws ClassNotFoundException, SQLException {
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
		ordemServicoDAO.atualizar(ordemServico);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
		ordemServicoDAO.deletar(id);
	}
	
}
