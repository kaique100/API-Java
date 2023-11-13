package br.com.porto.main.administrador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Administrador;
import br.com.porto.dao.AdministradorDAO;

public class AdministradorDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		AdministradorDAO dao = new AdministradorDAO();
		Administrador objAdministrador = new Administrador();
		
		objAdministrador.setIdAdministrador(id("Digite o codigo do administrador a ser deletado: "));
		System.out.println(dao.deletar(objAdministrador.getIdAdministrador()));

	}
	
}
