package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.OrdemServico;
import br.com.porto.conexoes.ConexaoFactory;

public class OrdemServicoDAO {

	public Connection guinchAppConexao;

	public OrdemServicoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(OrdemServico ordemServico) throws SQLException {

		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("INSERT INTO T_GPP_ORDEM_SERVICO values(?,?,?,?,?,?,?,?,?)");
		stmt.setLong(1, ordemServico.getIdOrdemServico());
		stmt.setLong(2, ordemServico.getIdGuinchoPrestadorServico());
		stmt.setLong(3, ordemServico.getIdVeiculo());
		
		String dateFormated = simplesFormat.format(ordemServico.getDataAbertura());
		stmt.setString(4, dateFormated);
		dateFormated = simplesFormat.format(ordemServico.getDataConclusao());
		stmt.setString(5, dateFormated);
		
		stmt.setString(6, ordemServico.getDescricaoServico());
		stmt.setString(7, ordemServico.getStatusServico());
		stmt.setString(8, ordemServico.getObservacaoServico());
		stmt.setString(9, ordemServico.getDescricaoEndereco());

		stmt.execute();
		stmt.close();
		return "Ordem de Seviço Cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_ORDEM_SERVICO WHERE id_ordem_servico = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Ordem de Seviço Deletado com Sucesso!";
	}

	// Update

	public String atualizar(OrdemServico ordemServico) throws SQLException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_ORDEM_SERVICO set id_guincho_prestador_servico = ?, id_veiculo = ?, dt_abertura = ?, "
						+ "ds_email = ?, nr_cpf = ?, dt_nascimento = ?, tl_celular = ?, "
						+ "dt_conclusao = ?, ds_servico =?, st_servico =?, "
						+ "ob_servico =?, ds_endereco where id_ordem_servico = ?");
		
		stmt.setLong(1, ordemServico.getIdGuinchoPrestadorServico());
		stmt.setLong(2, ordemServico.getIdVeiculo());
		
		String dateFormated = simplesFormat.format(ordemServico.getDataAbertura());
		stmt.setString(3, dateFormated);
		dateFormated = simplesFormat.format(ordemServico.getDataConclusao());
		stmt.setString(4, dateFormated);
		
		stmt.setString(5, ordemServico.getDescricaoServico());
		stmt.setString(6, ordemServico.getStatusServico());
		stmt.setString(7, ordemServico.getObservacaoServico());
		stmt.setString(8, ordemServico.getDescricaoEndereco());
		stmt.setLong(9, ordemServico.getIdOrdemServico());
		stmt.executeUpdate();
		stmt.close();

		return "Ordem de Seviço Atualizado com Sucesso!";
	}

	// Select

	public List<OrdemServico> selecionar() throws SQLException, ParseException {
		List<OrdemServico> listaOrdemServico = new ArrayList<OrdemServico>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_ORDEM_SERVICO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			OrdemServico ordemServico = new OrdemServico();
			ordemServico.setIdOrdemServico(rs.getLong(1));
			ordemServico.setIdGuinchoPrestadorServico(rs.getLong(2));
			ordemServico.setIdVeiculo(rs.getLong(3));
			ordemServico.setDataAbertura(rs.getString(4));
			ordemServico.setDataConclusao(rs.getString(5));
			ordemServico.setDescricaoServico(rs.getString(6));
			ordemServico.setStatusServico(rs.getString(7));
			ordemServico.setObservacaoServico(rs.getString(8));
			ordemServico.setDescricaoEndereco(rs.getString(9));
			listaOrdemServico.add(ordemServico);
		}

		return listaOrdemServico;

	}
	
}
