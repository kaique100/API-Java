package br.com.porto.main.guinchoPrestadorServico;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.dao.GuinchoPrestadorServicoDAO;

public class GuinchoPrestadorServicoDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		GuinchoPrestadorServicoDAO dao = new GuinchoPrestadorServicoDAO();
		GuinchoPrestadorServico objGuinchoPrestadorServico = new GuinchoPrestadorServico();
		
		objGuinchoPrestadorServico.setIdGuinchoPrestadorServico(id("Digite o codigo do Guincho Prestador Servico a ser deletado: "));
		System.out.println(dao.deletar(objGuinchoPrestadorServico.getIdGuinchoPrestadorServico()));

	}

}
