package br.com.porto.main.veiculo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Veiculo;
import br.com.porto.dao.VeiculoDAO;

public class VeiculoSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		VeiculoDAO da = new VeiculoDAO();

		List<Veiculo> listaVeiculo = (ArrayList<Veiculo>) da.selecionar();

		if (listaVeiculo != null) {
			for (Veiculo veiculo : listaVeiculo) {
				
				String dateFabrication = simplesFormat.format(veiculo.getFabricacao());
				
				System.out.println(
						veiculo.getIdVeiculo() + " " + veiculo.getIdCategoriaTarifaria() + " " + veiculo.getIdCliente() + " " 
						+ veiculo.getChassi() + " " + veiculo.getPlaca() + " " + veiculo.getCombustivel() + " " + veiculo.getCor()
						+ " " + veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getQuilometragem() + " "
						+ veiculo.getTransmissao() + " " + dateFabrication
						);
			}
		}

	}

}
