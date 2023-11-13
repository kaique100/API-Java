package br.com.porto.main.apolice;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Apolice;
import br.com.porto.dao.ApoliceDAO;

public class ApoliceUpdate {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	static double decimal (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		ApoliceDAO dao = new ApoliceDAO();
		Apolice objApolice = new Apolice();
		
		objApolice.setIdApolice(id("Digite o ID da Apolice a ser atualizado: "));
		objApolice.setIdVeiculo(id("Digite o ID do Veiculo: "));
		objApolice.setNumeroApolice(texto("Digite o Número da Apolice: "));
		objApolice.setNumeroEndosso(texto("Digite o Número do Endosso: "));
		objApolice.setNumeroProposta(texto("Digite o Número da Proposta: "));
		objApolice.setDataInicioVigente(texto("Digite a Data de Inicio da Apolice (dd/mm/yyyy): "));
		objApolice.setDataFinalVigente(texto("Digite a Data Final da Apolice (dd/mm/yyyy): "));
		objApolice.setDescricaoApolice(texto("Digite a Descrição da Apolice: "));
		objApolice.setValorPremioTotal(decimal("Digite o Valor Premio da Apolice: "));
		
		System.out.println(dao.atualizar(objApolice));
		
	}

}
