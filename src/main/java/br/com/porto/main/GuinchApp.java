package br.com.porto.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.porto.beans.Administrador;
import br.com.porto.beans.Apolice;
import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.beans.ChatBot;
import br.com.porto.beans.Cliente;
import br.com.porto.beans.Endereco;
import br.com.porto.beans.Guincho;
import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.beans.OrdemServico;
import br.com.porto.beans.PrestadorServico;
import br.com.porto.beans.TipoGuincho;
import br.com.porto.beans.TipoUsuario;
import br.com.porto.beans.Usuario;
import br.com.porto.beans.Veiculo;

public class GuinchApp {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static double decimal (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	
	static boolean decisao (String j) {
		return Boolean.parseBoolean(JOptionPane.showInputDialog(j));
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
//	static String data (String j) {
//		String format = "dd/MM/yyyy";
//		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
//		String dateFormated = simplesFormat.format(JOptionPane.showInputDialog(j));
//		return dateFormated;
//	}
	
	public static void main(String[] args) throws ParseException {
		
		//Class TipoUsuario
		List<TipoUsuario> listaTipoUsuarios = new ArrayList<TipoUsuario>();

		TipoUsuario objTipoUsuario = null;
		
		do {
			objTipoUsuario = new TipoUsuario();
			objTipoUsuario.setIdTipoUsuario(inteiro("Digite o id do tipo usuario: "));
			objTipoUsuario.setNivelAcesso(texto("Digite o nivel de acesso do tipo usuario: "));
			listaTipoUsuarios.add(objTipoUsuario);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Tipo Usuario?",
				"Cadastro de Tipo Usuario", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == 0);

		
//		Class Endereco
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		Endereco objEndereco = null;
		
		do {
			
			objEndereco = new Endereco();
			objEndereco.setIdEndereco(id("Digite o id do Endereço: "));
			objEndereco.setLogradouro(texto("Digite o logardouro do Endereço: "));
			objEndereco.setEstado(texto("Digite o estado do Endereço: "));
			objEndereco.setCep(texto("Digite o cep do Endereço: "));;
			objEndereco.setBairro(texto("Digite o bairro do Endereço: "));
			objEndereco.setCidade(texto("Digite a cidade do Endereço: "));
			listaEnderecos.add(objEndereco);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Endereço?",
				"Cadastro de Endereço", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) ==0);
		
		
//		Class Usuario
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario objUsuario = null;
		
		do {
			
			objUsuario = new Usuario();
			objUsuario.setIdUsuario(id("Digite o id do usuario: "));
			objUsuario.setNome(texto("Digite o nome do usuario: "));
			objUsuario.setEmail(texto("Digite o email do usuario: "));
			objUsuario.setCpf(texto("Digite o CPF do usuario: "));
			objUsuario.setCelular(texto("Digite o celular do usuario: "));
			objUsuario.setSenha(texto("Digite a senha do usuario: "));
			objUsuario.setDataCadastro(texto("Digite a data de cadastro do usuario: "));
			objUsuario.setDataNascimento(texto("Digite a data de nascimento do usuario: "));
			objUsuario.setIdTipoUsuario(id("Digite o id tipo do usuario: "));
			objUsuario.setIdEndereco(id("Digite o id do Endereço: "));
			
			listaUsuarios.add(objUsuario);
		} while(JOptionPane.showConfirmDialog(null, "Cadastrar novo Usuario?",
				"Cadastro de Usuario", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) ==0);
		
//		Class Administrador
		List<Administrador> listaAdministradors = new ArrayList<Administrador>();
		Administrador objAdministrador = null;
		
		
		do {
			
			objAdministrador = new Administrador();
			objAdministrador.setIdAdministrador(id("Digite o id do administrador: "));
			objAdministrador.setNumeroFuncionario(texto("Digite o numero do funcionario: "));
			objAdministrador.setDescricaoCargo(texto("Digite a descrição do cargo: "));
			objAdministrador.setIdUsuario(id("Digite o id do usuario"));
			
			listaAdministradors.add(objAdministrador);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Usuario Administrador?",
				"Cadastro de Usuario Administrador", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) ==0);
		
		
//		Class Cliente
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Cliente objCliente = null;
		
		do {
			
			objCliente =  new Cliente();
			objCliente.setIdCliente(id("Digite o id do Cliente: "));
			objCliente.setEstadoCivil(texto("Digite o estado civil do Cliente: "));
			objCliente.setSexo("Digite o sexo do Cliente: ");
			objCliente.setIdUsuario(id("Digite o id do Usuario: "));
			listaClientes.add(objCliente);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Cliente?",
				"Cadastro de Cliente", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) ==0);
		
		
//		Class PrestadorServico
		List<PrestadorServico> listaPrestadorServicos = new ArrayList<PrestadorServico>();
		PrestadorServico objPrestadorServico = null;
		
		do {
			
			objPrestadorServico = new PrestadorServico();
			objPrestadorServico.setIdPrestadorServico(id("Digite o id do Prestador de Serviço: "));
			objPrestadorServico.setNomePrestadorServico(texto("Digite o nome do Prestador de Serviço: "));
			objPrestadorServico.setDescricaoTipoServico(texto("Digite a descricao do Tipo de Serviço: "));
			objPrestadorServico.setDescricaoAreaCoberta(texto("Digite a descricao da Area de Serviço: "));
			objPrestadorServico.setObservacaoPrestadorServico(texto("Digite a observação do Prestador de Serviço: "));
			objPrestadorServico.setIdUsuario(id("Digite o id do Usuario: "));

			listaPrestadorServicos.add(objPrestadorServico);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Prestador de Serviço?",
				"Cadastro de Prestador de Serviço", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class TipoGuincho
		List<TipoGuincho> listaTipoGuinchos = new ArrayList<TipoGuincho>();
		TipoGuincho objTipoGuincho = null;
		
		do {
			
			objTipoGuincho = new TipoGuincho();
			objTipoGuincho.setIdTipoGuincho(id("Digite o id do Tipo Guincho: "));
			objTipoGuincho.setNumeroTipoGuincho(texto("Digite o número do Tipo Guincho: "));
			objTipoGuincho.setRestricao(texto("Digite a restição do Tipo Guincho: "));
			objTipoGuincho.setObservacaoTipoGuincho(texto("Digite a observação do Tipo Guincho: "));
			objTipoGuincho.setCapacidadeMaxima(decimal("Digite a capacidade maxima do Tipo Guincho: "));
			listaTipoGuinchos.add(objTipoGuincho);
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Tipo Guincho?",
				"Cadastro de Tipo Guincho", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class Guincho
		List<Guincho> listaGuinchos = new ArrayList<Guincho>();
		Guincho objGuincho  = null;
		
		do {
			
			objGuincho = new Guincho();
			objGuincho.setIdGuincho(id("Digite o id do Guincho: "));
			objGuincho.setPlaca(texto("Digite a placa do Guincho: "));
			objGuincho.setDescricaoGuincho(texto("Digite a descrição do Guincho: "));
			objGuincho.setObservacaoGuincho(texto("Digite a observação do Guincho: "));
			objGuincho.setDisponibilidade(decisao("Digite se o Guincho está disponivel\n(True para Disponivel)\n(False para Indisponivel): "));
			objGuincho.setIdTipoGuincho(id("Digite o id do Tipo Guincho: "));

			listaGuinchos.add(objGuincho);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Guincho?",
				"Cadastro de Guincho", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class GuinchoPrestadorServico
		List<GuinchoPrestadorServico> listaGuinchoPrestadorServicos = new ArrayList<GuinchoPrestadorServico>();
		GuinchoPrestadorServico objGuinchoPrestadorServico = null;
		
		do {
			
			objGuinchoPrestadorServico = new GuinchoPrestadorServico();
			objGuinchoPrestadorServico.setIdGuinchoPrestadorServico(id("Digite o id do Guincho Prestador Servico: "));
			objGuinchoPrestadorServico.setDescricaoLocalizacaoAtual(texto("Digite a descrição da localização atual: "));
			objGuinchoPrestadorServico.setIdPrestadorServico(id("Digite o id do Prestador de Serviço"));
			objGuinchoPrestadorServico.setIdGuincho(id("Digite o id do Guincho: "));

			listaGuinchoPrestadorServicos.add(objGuinchoPrestadorServico);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Guincho Prestador Servico?",
				"Cadastro de Guincho Prestador Servico", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class CategoriaTarifaria
		List<CategoriaTarifaria> listaCategoriaTarifarias = new ArrayList<CategoriaTarifaria>();
		CategoriaTarifaria objCategoriaTarifaria = null;
		
		do {
			
			objCategoriaTarifaria = new CategoriaTarifaria();
			objCategoriaTarifaria.setIdCategoriaTarifaria(id("Digite o id da Categoria Tarifaria: "));
			objCategoriaTarifaria.setNumeroCategoriaTarifaria(texto("Digite o numero da Categoria Tarifaria: "));
			objCategoriaTarifaria.setValorBase(decimal("Digite o valor base da Categoria Tarifaria: "));
			objCategoriaTarifaria.setValorPesoMaximo(decimal("Digite o valor peso maximo da Categoria Tarifaria: "));
			listaCategoriaTarifarias.add(objCategoriaTarifaria);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar nova Categoria Tarifaria?",
				"Cadastro de Categoria Tarifaria", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class Veiculo
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		Veiculo objVeiculo = null;

		do {
			
			objVeiculo = new Veiculo();
			objVeiculo.setIdVeiculo(id("Digite o id do Veiculo: "));
			objVeiculo.setMarca(texto("Digite a marca do Veiculo: "));
			objVeiculo.setModelo(texto("Digite o modelo do Veiculo: "));
			objVeiculo.setChassi(texto("Digite o chassi do Veiculo: "));
			objVeiculo.setPlaca(texto("Digite a placa do Veiculo: "));
			objVeiculo.setCor(texto("Digite a cor do Veiculo: "));
			objVeiculo.setCombustivel(texto("Digite o combustivel do Veiculo: "));
			objVeiculo.setTransmissao(texto("Digite a descriçao da transmissão do Veiculo: "));
			objVeiculo.setFabricacao(texto("Digite o ano de fabricação do Veiculo: "));
			objVeiculo.setQuilometragem(decimal("Digite a quilometragem do Veiculo: "));
			objVeiculo.setIdCliente(id("Digite o id do cliente dono do Veiculo: "));
			objVeiculo.setIdCategoriaTarifaria(id("Digiite o id da Categoria Tarifaria: "));

			listaVeiculos.add(objVeiculo);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo Veiculo?",
				"Cadastro de Veiculo", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class Apolice
		List<Apolice> listaApolices = new ArrayList<Apolice>(); 
		Apolice objApolice = null;
		
		
		do {
		
			objApolice = new Apolice();
			objApolice.setIdApolice(id("Digite o id da Apolice: "));
			objApolice.setNumeroApolice(texto("Digite o numero da Apolice: "));
			objApolice.setNumeroEndosso(texto("Digite o numero do endosso da Apolice: "));
			objApolice.setNumeroProposta(texto("Digite o numero da Proposta da Apolice: "));
			objApolice.setDescricaoApolice(texto("Digite a descrição da Apolice: "));
			objApolice.setDataInicioVigente(texto("Digite a data de inicio da Apolice: "));
			objApolice.setDataFinalVigente(texto("Digite a data final da Apolice: "));
			objApolice.setValorPremioTotal(decimal("Digite o valor premio total da Apolice: "));
			objApolice.setIdVeiculo(id("Digite o id do Veiculo: "));

			listaApolices.add(objApolice);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar nova Apolice?",
				"Cadastro de Apolice", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class OrdemServico 
		List<OrdemServico> listaOrdemServicos = new ArrayList<OrdemServico>();
		OrdemServico objOrdemServico = null;
		
		do {
			
			objOrdemServico = new OrdemServico();
			objOrdemServico.setIdOrdemServico(id("Digite o id da Ordem de Serviço: "));
			objOrdemServico.setDataAbertura(texto("Digite a data de abertura da Ordem de Serviço: "));
			objOrdemServico.setDataConclusao(texto("Digite a data de conclusão da Ordem de Serviço: "));
			objOrdemServico.setDescricaoServico(texto("Digite a descrição do Sreviço: "));
			objOrdemServico.setStatusServico(texto("Digite A para (Ativo) ou I para (Inativo): "));
			objOrdemServico.setObservacaoServico(texto("Digite a obeservação sobre a Ordem de Serviço: "));
			objOrdemServico.setDescricaoEndereco(texto("Digite a descrição do endereço da Ordem de Serviço: "));
			objOrdemServico.setIdGuinchoPrestadorServico(id("Digite o id do Guincho Prestador Serviço: "));
			objOrdemServico.setIdVeiculo(id("Digite o id do veiculo: "));

			listaOrdemServicos.add(objOrdemServico);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar nova Ordem Serviço?",
				"Cadastro de Ordem Serviço", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
//		Class ChatBot
		List<ChatBot> listaChatBots = new ArrayList<ChatBot>();
		ChatBot objChatBot = null;

		do {
			
			objChatBot = new ChatBot();
			objChatBot.setIdChatBot(id("Digite o id do ChatBot: "));
			objChatBot.setTextoEntrada(texto("Digite o texto de entrada do ChatBot: "));
			objChatBot.setTextoSaida(texto("Digite o texto de saida do ChatBot: "));
			objChatBot.setDescricaoIntencao(texto("Digite a descrição da intenção do ChatBot: "));
			objChatBot.setDataMensagem(texto("Digite a data da mensagem do ChatBot: "));
			objChatBot.setIdCliente(id("Digite o id do cliente: "));
			objChatBot.setIdOrdemServico(id("Digite o id da Ordem de Serviço: "));

			listaChatBots.add(objChatBot);
			
		} while (JOptionPane.showConfirmDialog(null, "Cadastrar novo ChatBot?",
				"Cadastro de ChatBot", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE)==0);
		
		
		//Saidas
		System.out.println("\n----------------------------------------\n");
		System.out.println("			Class Tipo Usuario");
		System.out.println("\n----------------------------------------\n");
		
		for(TipoUsuario tu : listaTipoUsuarios) {
			System.out.println(
					  "\nId Tipo Usuario: " + tu.getIdTipoUsuario()
					+ "\nNivel acesso Tipo Usuario: " + tu.getNivelAcesso() + "\n"
			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("			 Class Usuario");
		System.out.println("\n----------------------------------------\n");
		
		for (Usuario u : listaUsuarios) {
			System.out.println(
					  "\nId  Usuario: " + u.getIdUsuario()
					+ "\nNome Usuario: " + u.getNome()
					+ "\nE-mail Usuario: " + u.getEmail()
					+ "\nCpf Usuario: " + u.getCpf()
					+ "\nCelular Usuario: " + u.getCelular()
					+ "\nSenha Usuario: " + u.getSenha()
					+ "\nData Nascimento Usuario: " + u.getDataNascimento()
					+ "\nData Cadatro Usuario: " + u.getDataCadastro()
					+ "\nId Tipo Usuario: " + u.getIdTipoUsuario() 
					+ "\nId Endereço: " + u.getIdEndereco() + "\n"
							
			);
			
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("			Class Administrador");
		System.out.println("\n----------------------------------------\n");
		
		for(Administrador a : listaAdministradors) {
			System.out.println(
					  "\nId Administrador: " + a.getIdAdministrador()
					+ "\nNúmero Funcionario: " + a.getNumeroFuncionario()
					+ "\nDescrição Cargo: " + a.getDescricaoCargo()
					+ "\nId Uauario: " + a.getIdUsuario() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("			 Class Endereco");
		System.out.println("\n----------------------------------------\n");
		
		for(Endereco e : listaEnderecos) {
			System.out.println(
					  "\nId Endereço: " + e.getIdEndereco()
					+ "\nLogradouro: " + e.getLogradouro()
					+ "\nEstado: " + e.getEstado()
					+ "\nCep: " + e.getCep()
					+ "\nBairro: " + e.getBairro()
					+ "\nCidade: " + e.getCidade() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("				Class Cliente");
		System.out.println("\n----------------------------------------\n");

		for(Cliente c : listaClientes) {
			System.out.println(
					  "\nId Cliente: " + c.getIdCliente()
					+ "\nEstado Civil: " + c.getEstadoCivil()
					+ "\nSexo: " + c.getSexo()
					+ "\nId Usuario: " + c.getIdUsuario() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("		 Class PrestadorServico");
		System.out.println("\n----------------------------------------\n");
		
		for(PrestadorServico ps : listaPrestadorServicos) {
			System.out.println(
					  "\nId Prestador de Serviço: " + ps.getIdPrestadorServico()
					+ "\nNome Prestador de Serviço: " + ps.getNomePrestadorServico()
					+ "\nDescriçao do Tipo de Serviço: " + ps.getDescricaoTipoServico()
					+ "\nDescrição da Area Coberta pelo Prestador de Serviço: " + ps.getDescricaoAreaCoberta()
					+ "\nObservação sobre o Prestador de Serviço: " + ps.getObservacaoPrestadorServico()
					+ "\nId Usuario: " + ps.getIdUsuario() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("			Class TipoGuincho");
		System.out.println("\n----------------------------------------\n");
		
		for(TipoGuincho tg : listaTipoGuinchos) {
			System.out.println(
					  "\nId Tipo de Guincho: " + tg.getIdTipoGuincho()
					+ "\nNúmero Tipo do Guincho: " + tg.getNumeroTipoGuincho()
					+ "\nRestrição Tipo Guincho: " + tg.getRestricao()
					+ "\nObsercação Tipo do Guincho: " + tg.getObservacaoTipoGuincho()
					+ "\nCapacidade Maxima Tipo Guincho: " + tg.getCapacidadeMaxima()
			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("			  Class Guincho");
		System.out.println("\n----------------------------------------\n");

		for(Guincho g: listaGuinchos) {
			System.out.println(
					  "\nId Guincho: " + g.getIdGuincho()
					+ "\nPlaca do Guincho: " + g.getPlaca()
					+ "\nDescrição do Guincho: " + g.getDescricaoGuincho()
					+ "\nObservação do Guincho: " + g.getObservacaoGuincho()
					+ "\nDisponibilidade do Guincho: " + g.isDisponibilidade()
					+ "\nId Tipo do Guincho: " + g.getIdTipoGuincho()+ "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("	  Class GuinchoPrestadorServico");
		System.out.println("\n----------------------------------------\n");

		for(GuinchoPrestadorServico gps: listaGuinchoPrestadorServicos) {
			System.out.println(
					  "\nId Guincho Prestador Serviço: " + gps.getIdGuinchoPrestadorServico()
					+ "\nDescricao Localização Atual: " + gps.getDescricaoLocalizacaoAtual()
					+ "\nId Prestador Serviço: " + gps.getIdPrestadorServico()
					+ "\nId Guincho: " + gps.getIdGuincho() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("	  	 Class CategoriaTarifaria");
		System.out.println("\n----------------------------------------\n");
		
		for(CategoriaTarifaria ct: listaCategoriaTarifarias) {
			System.out.println(
				  "\nId Categoria Tarifaria: " + ct.getIdCategoriaTarifaria()
				+ "\nNúmero Categoria Tarifaria: " + ct.getNumeroCategoriaTarifaria()
				+ "\nValor Base Categoria Tarifaria: " + ct.getValorBase()
				+ "\nValor Peso Máximo Categoria Tarifaria: " + ct.getValorPesoMaximo()
				+ "\nCalculo Categoria Tarifaria: " + ct.CalcularCategoriaTarifaria(ct.getValorBase(), ct.getValorPesoMaximo()) + "\n"
			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("	  	 		Class Veiculo");
		System.out.println("\n----------------------------------------\n");
		
		for(Veiculo v: listaVeiculos) {
			System.out.println(
					  "\nId do Veiculo: " + v.getIdVeiculo()
					+ "\nMarca do Veiculo: " + v.getMarca()
					+ "\nModelo do Veiculo: " + v.getModelo()
					+ "\nChassi do Veiculo: " + v.getChassi()
					+ "\nPlaca do Veiculo: " + v.getPlaca()
					+ "\nCor do Veiculo: " + v.getCor()
					+ "\nCombústivel do Veiculo: " + v.getCombustivel()
					+ "\nDescrição Transmissão do Veiculo: " + v.getTransmissao()
					+ "\nAno Fabricação do Veiculo: " + v.getFabricacao()
					+ "\nQuilometragem do Veiculo: " + v.getQuilometragem()
					+ "\nId Cliente: " + v.getIdCliente()
					+ "\nId Categoria Tarifaria: " + v.getIdCategoriaTarifaria() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("	  	 		Class Apolice");
		System.out.println("\n----------------------------------------\n");

		for(Apolice a : listaApolices) {
			System.out.println(
					  "\nId da Apolice: " + a.getIdApolice()
					+ "\nNúmero da Apolice: " + a.getNumeroApolice()
					+ "\nNúmero Endosso da Apolice: " + a.getNumeroEndosso()
					+ "\nNúmero Proposta da Apolice: " + a.getNumeroProposta()
					+ "\nDescrição da Apolice: " + a.getDescricaoApolice()
					+ "\nData Inicio Vigente da Apolice: " + a.getDataInicioVigente()
					+ "\nData Final Vigente da Apolice: " + a.getDataFinalVigente()
					+ "\nValor Premio Total da Apolice: " + a.getValorPremioTotal()
					+ "\nId do Veiculo: " + a.getIdVeiculo() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("	  	 	Class OrdemServico");
		System.out.println("\n----------------------------------------\n");

		for(OrdemServico os : listaOrdemServicos) {
			System.out.println(
					  "\nId Ordem de Serviço: " + os.getIdOrdemServico()
					+ "\nData Abertura Ordem de Serviço: " + os.getDataAbertura()
					+ "\nData Conclusão Ordem de Serviço: " + os.getDataConclusao()
					+ "\nDescrição Serviço: " + os.getDescricaoServico()
					+ "\nStatus Ordem de Serviço: " + os.getStatusServico()
					+ "\nObservação Ordem de Serviço: " + os.getObservacaoServico()
					+ "\nDescrição Endereço Ordem de Serviço: " + os.getDescricaoEndereco()
					+ "\nId Guincho Prestador Serviço: " + os.getIdGuinchoPrestadorServico()
					+ "\nId Veiculo: " + os.getIdVeiculo() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
		System.out.println("	  	 	  Class ChatBot");
		System.out.println("\n----------------------------------------\n");

		for(ChatBot cb : listaChatBots) {
			System.out.println(
					  "\nId do ChatBot: " + cb.getIdChatBot()
					+ "\nTexto Entrada do ChatBot: " + cb.getTextoEntrada()
					+ "\nTexto Saida do ChatBot: " + cb.getTextoSaida()
					+ "\nDescrição da Intenção do ChatBot: " + cb.getDescricaoIntencao()
					+ "\nData Mensagem: " + cb.getDataMensagem()
					+ "\nId Cliente: " + cb.getIdCliente()
					+ "\nId Ordem Serviço: " + cb.getIdOrdemServico() + "\n"

			);
		}
		
		System.out.println("\n----------------------------------------\n");
	}

}
