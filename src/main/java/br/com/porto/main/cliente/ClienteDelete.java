package br.com.porto.main.cliente;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Cliente;
import br.com.porto.dao.ClienteDAO;

public class ClienteDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		ClienteDAO dao = new ClienteDAO();
		Cliente objCliente = new Cliente();
		
		objCliente.setIdCliente(id("Digite o codigo do cliente a ser deletado: "));
		System.out.println(dao.deletar(objCliente.getIdCliente()));

	}

}
