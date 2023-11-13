package br.com.porto.main.categoriaTarifaria;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.dao.CategoriaTarifariaDAO;

public class CategoriaTarifariaUpdate {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	static double decimal (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		CategoriaTarifariaDAO dao = new CategoriaTarifariaDAO();
		CategoriaTarifaria objCategoriaTarifaria = new CategoriaTarifaria();
		
		objCategoriaTarifaria.setIdCategoriaTarifaria(id("Digite o ID da Categoria Tarifaria a ser atualizada: "));
		objCategoriaTarifaria.setNumeroCategoriaTarifaria(texto("Digite o Numero da Categoria Tarifaria: "));
		objCategoriaTarifaria.setValorBase(decimal("Digite o valor base da Categoria Tarifaria: "));
		objCategoriaTarifaria.setValorPesoMaximo(decimal("Digite o peso maximo da Categoria Tarifaria: "));
		
		System.out.println(dao.atualizar(objCategoriaTarifaria));

	}

}
