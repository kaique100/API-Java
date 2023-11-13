package br.com.porto.main.guincho;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Guincho;
import br.com.porto.dao.GuinchoDAO;

public class GuinchoDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		GuinchoDAO dao = new GuinchoDAO();
		Guincho objGuincho = new Guincho();
		
		objGuincho.setIdGuincho(id("Digite o codigo do Guincho a ser deletado: "));
		System.out.println(dao.deletar(objGuincho.getIdGuincho()));

	}

}
