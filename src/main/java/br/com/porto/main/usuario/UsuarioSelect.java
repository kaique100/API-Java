package br.com.porto.main.usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Usuario;
import br.com.porto.dao.UsuarioDAO;

public class UsuarioSelect {

	public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		UsuarioDAO da = new UsuarioDAO();

		List<Usuario> listaUsuario = (ArrayList<Usuario>) da.selecionar();

		if (listaUsuario != null) {
			for (Usuario usuario : listaUsuario) {
				
				String birthdate = simplesFormat.format(usuario.getDataNascimento());
				String registrationDate = simplesFormat.format(usuario.getDataCadastro());
				
				System.out.println(
						usuario.getIdUsuario() + " " + usuario.getIdEndereco() + " " + usuario.getIdTipoUsuario() + " " 
						+ usuario.getCelular() + " " + usuario.getCpf() + " " + usuario.getEmail() + " " + usuario.getNome()
						+ " " + birthdate + " " + registrationDate
						);
			}
		}

	}

}
