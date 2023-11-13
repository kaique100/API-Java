package br.com.porto.main.endereco;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Endereco;
import br.com.porto.dao.EnderecoDAO;

public class EnderecoInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco objEndereco = new Endereco();
		
		objEndereco.setIdEndereco(id("Digite o ID Endereço: "));
		objEndereco.setLogradouro(texto("Digite o Logradouro: "));
		objEndereco.setCep(texto("Digite o Cep: "));
		objEndereco.setCidade(texto("Digite a Cidade: "));
		objEndereco.setEstado(texto("Digite o Estado: "));
		objEndereco.setBairro(texto("Digite o Bairro: "));
		
		System.out.println(dao.insert(objEndereco));

	}

}
