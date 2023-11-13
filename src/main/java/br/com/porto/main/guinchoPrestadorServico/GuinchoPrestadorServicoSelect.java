package br.com.porto.main.guinchoPrestadorServico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.dao.GuinchoPrestadorServicoDAO;

public class GuinchoPrestadorServicoSelect {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		GuinchoPrestadorServicoDAO da = new GuinchoPrestadorServicoDAO();

		List<GuinchoPrestadorServico> listaGuinchoPrestadorServico = (ArrayList<GuinchoPrestadorServico>) da.selecionar();

		if (listaGuinchoPrestadorServico != null) {
			for (GuinchoPrestadorServico guinchoPrestadorServico : listaGuinchoPrestadorServico) {
				System.out.println(
						guinchoPrestadorServico.getIdGuinchoPrestadorServico() + " " + guinchoPrestadorServico.getIdGuincho() + " " 
						+ guinchoPrestadorServico.getIdPrestadorServico() + " " + guinchoPrestadorServico.getDescricaoLocalizacaoAtual()
						);
			}
		}

	}

}
