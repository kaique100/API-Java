package br.com.porto.main.ordemServico;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.com.porto.beans.OrdemServico;
import br.com.porto.dao.OrdemServicoDAO;

public class OrdemServicoInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		OrdemServicoDAO dao = new OrdemServicoDAO();
		OrdemServico objOrdemServico = new OrdemServico();
		
		objOrdemServico.setIdOrdemServico(id("Digite o ID da Ordem Serviço: "));
		objOrdemServico.setIdGuinchoPrestadorServico(id("Digite o ID do Guincho Prestador de Serviço: "));
		objOrdemServico.setIdVeiculo(id("Diigte o ID do Veiculo: "));
		objOrdemServico.setDataAbertura(texto("Digite a Data de Abertura da Ordem Serviço (dd/mm/yyyy): "));
		objOrdemServico.setDataConclusao(texto("Digite a Data de Conclusão da Ordem Serviço (dd/mm/yyyy): "));
		objOrdemServico.setDescricaoEndereco(texto("Digite a descrição de endereço da Ordem Serviço: "));
		objOrdemServico.setDescricaoServico(texto("Digite a descrição da Ordem Serviço: "));
		objOrdemServico.setObservacaoServico(texto("Digite a observação da Ordem Serviço: "));
		objOrdemServico.setStatusServico(texto("Digite o Status da Ordem Serviço \n0(Não iniciado) \n1(Em andamento) \n2(Concluido) : "));
		
		System.out.println(dao.insert(objOrdemServico));

	}

}
