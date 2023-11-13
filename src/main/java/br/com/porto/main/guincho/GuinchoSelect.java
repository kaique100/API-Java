package br.com.porto.main.guincho;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Guincho;
import br.com.porto.dao.GuinchoDAO;

public class GuinchoSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		GuinchoDAO da = new GuinchoDAO();

		List<Guincho> listaCategoriaTarifaria = (ArrayList<Guincho>) da.selecionar();

		if (listaCategoriaTarifaria != null) {
			for (Guincho guincho : listaCategoriaTarifaria) {
				System.out.println(
						guincho.getIdGuincho() + " " + guincho.getIdTipoGuincho() 
						+ " " + guincho.getPlaca() + " " + guincho.getObservacaoGuincho() 
						+ " " + guincho.getDescricaoGuincho() + " " + guincho.isDisponibilidade()
						);
			}
		}

	}

}
