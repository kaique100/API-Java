package br.com.porto.main.administrador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Administrador;
import br.com.porto.dao.AdministradorDAO;

public class AdministradorSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AdministradorDAO da = new AdministradorDAO();

		List<Administrador> listaAdministrador = (ArrayList<Administrador>) da.selecionar();

		if (listaAdministrador != null) {
			for (Administrador administrador : listaAdministrador) {
				System.out.println(
						administrador.getIdAdministrador() + " " + administrador.getIdUsuario() + " " + administrador.getDescricaoCargo()
						+ " " + administrador.getNumeroFuncionario()
						);
			}
		}

	}

}
