package br.com.porto.main.tipoUsuario;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.TipoUsuario;
import br.com.porto.dao.TipoUsuarioDAO;

public class TipoUsuarioDelete {

	static int id (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		TipoUsuario objTipoUsuario = new TipoUsuario();
		
		objTipoUsuario.setIdTipoUsuario(id("Digite o codigo do tipo usuario a ser deletado: "));
		System.out.println(dao.deletar(objTipoUsuario.getIdTipoUsuario()));

	}

}
