package br.com.porto.main.ordemServico;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.OrdemServico;
import br.com.porto.dao.OrdemServicoDAO;

public class OrdemServicoSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		OrdemServicoDAO da = new OrdemServicoDAO();

		List<OrdemServico> listaOrdemServico = (ArrayList<OrdemServico>) da.selecionar();

		if (listaOrdemServico != null) {
			for (OrdemServico ordemServico : listaOrdemServico) {
				
				String openingDate = simplesFormat.format(ordemServico.getDataAbertura());
				String dateCompleted = simplesFormat.format(ordemServico.getDataConclusao());
				
				System.out.println(
						ordemServico.getIdOrdemServico() + " " + ordemServico.getIdGuinchoPrestadorServico() + " " 
						+ ordemServico.getIdVeiculo() + " " + ordemServico.getDescricaoEndereco() + " " + ordemServico.getDescricaoServico() 
						+ " " + ordemServico.getObservacaoServico() + " " + ordemServico.getStatusServico() + " " 
						+ openingDate + " " + dateCompleted
						);
			}
		}

	}

}
