package br.com.porto.main.administrador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Administrador;
import br.com.porto.dao.AdministradorDAO;

public class AdministradorInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AdministradorDAO dao = new AdministradorDAO();
		Administrador objAdministrador = new Administrador();
		
		objAdministrador.setIdAdministrador(id("Digite o ID do Administrador: "));
		objAdministrador.setIdUsuario(id("Digite o ID do Usuario: "));
		objAdministrador.setDescricaoCargo(texto("Digite a descrição do cargo do Administrador: "));
		objAdministrador.setNumeroFuncionario(texto("Digite o numero do funcionario: "));
		
		System.out.println(dao.insert(objAdministrador));

	}

}
