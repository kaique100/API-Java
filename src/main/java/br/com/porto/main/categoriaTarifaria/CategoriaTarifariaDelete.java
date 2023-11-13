package br.com.porto.main.categoriaTarifaria;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.dao.CategoriaTarifariaDAO;

public class CategoriaTarifariaDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		CategoriaTarifariaDAO dao = new CategoriaTarifariaDAO();
		CategoriaTarifaria objCategoriaTarifaria = new CategoriaTarifaria();
		
		objCategoriaTarifaria.setIdCategoriaTarifaria(id("Digite o codigo da Categoria Tarifaria a ser deletado: "));
		System.out.println(dao.deletar(objCategoriaTarifaria.getIdCategoriaTarifaria()));

	}

}
