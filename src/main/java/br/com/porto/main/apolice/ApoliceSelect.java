package br.com.porto.main.apolice;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Apolice;
import br.com.porto.dao.ApoliceDAO;

public class ApoliceSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		ApoliceDAO da = new ApoliceDAO();

		List<Apolice> listaApolice = (ArrayList<Apolice>) da.selecionar();

		if (listaApolice != null) {
			for (Apolice apolice : listaApolice) {
				
				String startDate  = simplesFormat.format(apolice.getDataInicioVigente());
				String endDate = simplesFormat.format(apolice.getDataFinalVigente());
				
				System.out.println(
						apolice.getIdApolice() + " " + apolice.getIdVeiculo() + " " + apolice.getNumeroApolice() + " " 
						+ apolice.getNumeroEndosso() + " " + apolice.getNumeroProposta() + " " + apolice.getDescricaoApolice() 
						+ " " + apolice.getValorPremioTotal() + " " + startDate + " " + endDate
						);
			}
		}

	}

}
