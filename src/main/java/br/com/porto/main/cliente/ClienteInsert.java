package br.com.porto.main.cliente;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Cliente;
import br.com.porto.dao.ClienteDAO;

public class ClienteInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ClienteDAO dao = new ClienteDAO();
		Cliente objCliente = new Cliente();
		
		objCliente.setIdCliente(id("Digite o ID do Cliente: "));
		objCliente.setIdUsuario(id("Digite o ID do Usuario: "));
		objCliente.setEstadoCivil(texto("Digite o estado civil do Cliente: "));
		objCliente.setSexo(texto("Digite o sexo do Cliente: "));
		
		System.out.println(dao.insert(objCliente));

	}

}
