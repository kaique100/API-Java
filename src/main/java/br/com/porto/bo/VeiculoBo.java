package br.com.porto.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.porto.beans.Veiculo;
import br.com.porto.dao.VeiculoDAO;

public class VeiculoBo {

	VeiculoDAO veiculoDAO;

	// selecionar
	public ArrayList<Veiculo> selecionarBO() throws ClassNotFoundException, SQLException, ParseException {

		veiculoDAO = new VeiculoDAO();

		return (ArrayList<Veiculo>) veiculoDAO.selecionar();

	}

	// inserir
	public void inserirBO(Veiculo veiculo) throws ClassNotFoundException, SQLException {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.insert(veiculo);
	}

	// atualizar
	public void atualizarBO(Veiculo veiculo) throws ClassNotFoundException, SQLException {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.atualizar(veiculo);
	}

	// deletar
	public void deletarBO(Long id) throws ClassNotFoundException, SQLException {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.deletar(id);
	}
	
}
