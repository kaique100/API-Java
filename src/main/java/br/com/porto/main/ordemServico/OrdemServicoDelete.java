package br.com.porto.main.ordemServico;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.OrdemServico;
import br.com.porto.dao.OrdemServicoDAO;

public class OrdemServicoDelete {

	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		OrdemServicoDAO dao = new OrdemServicoDAO();
		OrdemServico objOrdemServico = new OrdemServico();
		
		objOrdemServico.setIdOrdemServico(id("Digite o codigo da Ordem Serviço a ser deletado: "));
		System.out.println(dao.deletar(objOrdemServico.getIdOrdemServico()));

	}

}
