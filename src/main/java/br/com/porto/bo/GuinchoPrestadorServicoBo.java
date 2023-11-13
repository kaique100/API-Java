package br.com.porto.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.dao.GuinchoPrestadorServicoDAO;

public class GuinchoPrestadorServicoBo {

	GuinchoPrestadorServicoDAO guinchoPrestadorServicoDAO;

	// selecionar
	public ArrayList<GuinchoPrestadorServico> selecionarBO() throws ClassNotFoundException, SQLException {

		guinchoPrestadorServicoDAO = new GuinchoPrestadorServicoDAO();

		return (ArrayList<GuinchoPrestadorServico>) guinchoPrestadorServicoDAO.selecionar();

	}

	// inserir
	public void inserirBO(GuinchoPrestadorServico guinchoPrestadorServico) throws ClassNotFoundException, SQLException {
		GuinchoPrestadorServicoDAO guinchoPrestadorServicoDAO = new GuinchoPrestadorServicoDAO();
		guinchoPrestadorServicoDAO.insert(guinchoPrestadorServico);
	}

	// atualizar
	public void atualizarBO(GuinchoPrestadorServico guinchoPrestadorServico) throws ClassNotFoundException, SQLException {
		GuinchoPrestadorServicoDAO guinchoPrestadorServicoDAO = new GuinchoPrestadorServicoDAO();
		guinchoPrestadorServicoDAO.atualizar(guinchoPrestadorServico);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		GuinchoPrestadorServicoDAO guinchoPrestadorServicoDAO = new GuinchoPrestadorServicoDAO();
		guinchoPrestadorServicoDAO.deletar(id);
	}
	
}
