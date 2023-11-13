package br.com.porto.main.cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Cliente;
import br.com.porto.dao.ClienteDAO;

public class ClienteSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ClienteDAO da = new ClienteDAO();

		List<Cliente> listaCliente = (ArrayList<Cliente>) da.selecionar();

		if (listaCliente != null) {
			for (Cliente cliente : listaCliente) {
				System.out.println(
						cliente.getIdCliente() + " " + cliente.getIdUsuario() + " " + cliente.getEstadoCivil()
						+ " " + cliente.getSexo()
						);
			}
		}

	}
	
}
