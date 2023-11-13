package br.com.porto.main.guinchoPrestadorServico;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.dao.GuinchoPrestadorServicoDAO;

public class GuinchoPrestadorServicoInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		GuinchoPrestadorServicoDAO dao = new GuinchoPrestadorServicoDAO();
		GuinchoPrestadorServico objGuinchoPrestadorServico = new GuinchoPrestadorServico();
		
		objGuinchoPrestadorServico.setIdGuinchoPrestadorServico(id("Digite o ID do Guincho Prestador Serviço: "));
		objGuinchoPrestadorServico.setIdGuincho(id("Digite o ID do Guincho: "));
		objGuinchoPrestadorServico.setIdPrestadorServico(id("Digite do Prestador de Serviço: "));
		objGuinchoPrestadorServico.setDescricaoLocalizacaoAtual(texto("Digite a descrição da localização atual: "));
		
		System.out.println(dao.insert(objGuinchoPrestadorServico));

	}

}
