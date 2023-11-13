package br.com.porto.main.veiculo;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Veiculo;
import br.com.porto.dao.VeiculoDAO;

public class VeiculoInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	static double decimal (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		VeiculoDAO dao = new VeiculoDAO();
		Veiculo objVeiculo = new Veiculo();
		
		objVeiculo.setIdVeiculo(id("Digite o ID do Veiculo: "));
		objVeiculo.setIdCategoriaTarifaria(id("Digite o ID da Categoria Tarifaria do Veiculo: "));
		objVeiculo.setIdCliente(id("Diigte o ID do Tipo do Cliente dono do Veiculo: "));
		objVeiculo.setMarca(texto("Digite a marca do Veiculo: "));
		objVeiculo.setModelo(texto("Digite o  modelo do Veiculo: "));
		objVeiculo.setFabricacao(texto("Digite a data de fabricação do Veiculo (dd/mm/yyyy): "));
		objVeiculo.setChassi(texto("Digite o Chassi do Veiculo: "));
		objVeiculo.setPlaca(texto("Digite a placa do Veiculo: "));
		objVeiculo.setCor(texto("Digite a cor do Veiculo: "));
		objVeiculo.setCombustivel(texto("Digite o tipo do Combústivel do Veiculo: "));
		objVeiculo.setTransmissao(texto("Digite a Transmissão do Veiculo: "));
		objVeiculo.setQuilometragem(decimal("Digite a Quilometragem do Veiculo: "));
		
		System.out.println(dao.insert(objVeiculo));

	}

}
