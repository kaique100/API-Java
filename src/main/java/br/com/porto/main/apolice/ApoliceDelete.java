package br.com.porto.main.apolice;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Apolice;
import br.com.porto.dao.ApoliceDAO;

public class ApoliceDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		ApoliceDAO dao = new ApoliceDAO();
		Apolice objApolice = new Apolice();
		
		objApolice.setIdApolice(id("Digite o codigo da Apolice a ser deletado: "));
		System.out.println(dao.deletar(objApolice.getIdApolice()));

	}

}
