package br.com.porto.main.endereco;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Endereco;
import br.com.porto.dao.EnderecoDAO;

public class EnderecoDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco objEndereco = new Endereco();
		
		objEndereco.setIdEndereco(id("Digite o codigo do Endereço a ser deletado: "));
		System.out.println(dao.deletar(objEndereco.getIdEndereco()));

	}

}
