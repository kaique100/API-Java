package br.com.porto.main.categoriaTarifaria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.dao.CategoriaTarifariaDAO;

public class CategoriaTarifariaSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		CategoriaTarifariaDAO da = new CategoriaTarifariaDAO();

		List<CategoriaTarifaria> listaCategoriaTarifaria = (ArrayList<CategoriaTarifaria>) da.selecionar();

		if (listaCategoriaTarifaria != null) {
			for (CategoriaTarifaria administrador : listaCategoriaTarifaria) {
				System.out.println(
						administrador.getIdCategoriaTarifaria() + " " + administrador.getNumeroCategoriaTarifaria() 
						+ " " + administrador.getValorBase() + " " + administrador.getValorPesoMaximo()
						);
			}
		}

	}

}
