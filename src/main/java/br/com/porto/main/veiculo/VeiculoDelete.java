package br.com.porto.main.veiculo;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Veiculo;
import br.com.porto.dao.VeiculoDAO;

public class VeiculoDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		VeiculoDAO dao = new VeiculoDAO();
		Veiculo objVeiculo = new Veiculo();
		
		objVeiculo.setIdVeiculo(id("Digite o codigo do Veiculo a ser deletado: "));
		System.out.println(dao.deletar(objVeiculo.getIdVeiculo()));

	}

}
