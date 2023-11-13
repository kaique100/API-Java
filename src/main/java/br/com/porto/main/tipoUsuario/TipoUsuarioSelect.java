package br.com.porto.main.tipoUsuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.TipoUsuario;
import br.com.porto.dao.TipoUsuarioDAO;

public class TipoUsuarioSelect {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		TipoUsuarioDAO da = new TipoUsuarioDAO();

		List<TipoUsuario> listaTipoUsuario = (ArrayList<TipoUsuario>) da.selecionar();

		if (listaTipoUsuario != null) {
			for (TipoUsuario tipoUsuario : listaTipoUsuario) {
				System.out.println(
						tipoUsuario.getIdTipoUsuario() + " " + tipoUsuario.getNivelAcesso());
			}
		}

	}

}
