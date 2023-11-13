package br.com.porto.main.endereco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Endereco;
import br.com.porto.dao.EnderecoDAO;

public class EnderecoSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		EnderecoDAO da = new EnderecoDAO();

		List<Endereco> listaEndereco = (ArrayList<Endereco>) da.selecionar();

		if (listaEndereco != null) {
			for (Endereco endereco : listaEndereco) {
				System.out.println(
						endereco.getIdEndereco() + " " + endereco.getBairro() + " " + endereco.getCep() + " " + endereco.getCidade()
						+ " " + endereco.getEstado() + " " + endereco.getLogradouro()
						);
			}
		}

	}

}
