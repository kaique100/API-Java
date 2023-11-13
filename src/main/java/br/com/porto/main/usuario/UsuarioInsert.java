package br.com.porto.main.usuario;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import br.com.porto.beans.Usuario;
import br.com.porto.dao.UsuarioDAO;

public class UsuarioInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objUsuario = new Usuario();
		
		objUsuario.setIdUsuario(id("Digite o ID do Usuario: "));
		objUsuario.setIdEndereco(id("Digite o ID do Endereço do Usuario: "));
		objUsuario.setIdTipoUsuario(id("Diigte o ID do Tipo do Usuario: "));
		objUsuario.setNome(texto("Digite o Nome do Usuario: "));
		objUsuario.setEmail(texto("Digite o E-mail do Usuario: "));
		objUsuario.setCpf(texto("Digite o CPF do Usuario: "));
		objUsuario.setDataNascimento(texto("Digite a Data de Nascimento do Usuario (dd/mm/yyyy): "));
		objUsuario.setCelular(texto("Digite o Celular do Usuario: "));
		objUsuario.setSenha(texto("Digite a Senha do Usuario: "));
		objUsuario.setDataCadastro(texto("Digite a Data de Cadastramento do Usuario (dd/mm/yyyy): "));
		
		System.out.println(dao.insert(objUsuario));

	}

}
