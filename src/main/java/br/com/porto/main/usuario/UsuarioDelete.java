package br.com.porto.main.usuario;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Usuario;
import br.com.porto.dao.UsuarioDAO;

public class UsuarioDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objUsuario = new Usuario();
		
		objUsuario.setIdUsuario(id("Digite o codigo do Usuario a ser deletado: "));
		System.out.println(dao.deletar(objUsuario.getIdUsuario()));

	}

}
