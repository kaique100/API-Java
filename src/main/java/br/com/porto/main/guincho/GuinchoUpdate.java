package br.com.porto.main.guincho;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Guincho;
import br.com.porto.dao.GuinchoDAO;

public class GuinchoUpdate {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	static boolean decisao (String j) {
		return Boolean.parseBoolean(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		GuinchoDAO dao = new GuinchoDAO();
		Guincho objGuincho = new Guincho();
		
		objGuincho.setIdGuincho(id("Digite o ID do Guincho a ser atualizado: "));
		objGuincho.setIdTipoGuincho(id("Digite o ID do Tipo Guincho: "));
		objGuincho.setDescricaoGuincho(texto("Digite a descrição do Guincho: "));
		objGuincho.setDisponibilidade(decisao("Digite a disponibilidade do Guincho \n 1(Disponivel) \n 0(Indisponivel): "));
		objGuincho.setPlaca(texto("Digite a placa do Guincho: "));
		objGuincho.setObservacaoGuincho(texto("Digite a observação do Guincho: "));
		
		System.out.println(dao.atualizar(objGuincho));

	}

}
