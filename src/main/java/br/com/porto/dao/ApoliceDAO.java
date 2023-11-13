package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Apolice;
import br.com.porto.conexoes.ConexaoFactory;

public class ApoliceDAO {

	
	public Connection guinchAppConexao;

	public ApoliceDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Apolice apolice) throws SQLException {

		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("INSERT INTO T_GPP_APOLICE values(?,?,?,?,?,?,?,?,?)");
		stmt.setLong(1, apolice.getIdApolice());
		stmt.setLong(2, apolice.getIdVeiculo());
		stmt.setString(3, apolice.getNumeroApolice());
		stmt.setString(4, apolice.getNumeroEndosso());
		stmt.setString(5, apolice.getNumeroProposta());
		
		String dateFormated = simplesFormat.format(apolice.getDataInicioVigente());
		stmt.setString(6, dateFormated);
		dateFormated = simplesFormat.format(apolice.getDataFinalVigente());
		stmt.setString(7, dateFormated);
		
		stmt.setString(8, apolice.getDescricaoApolice());
		stmt.setDouble(9, apolice.getValorPremioTotal());
		stmt.execute();
		stmt.close();
		return "Apolice cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_APOLICE WHERE id_apolice = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Apolice Deletado com Sucesso!";
	}

	// Update

	public String atualizar(Apolice apolice) throws SQLException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_APOLICE set id_veiculo = ?, nr_apolice = ?, nr_endosso = ?, "
						+ "ds_email = ?, nr_cpf = ?, dt_nascimento = ?, tl_celular = ?, "
						+ "nr_proposta = ?, dt_inicio_vigencia =?, dt_final_vigencia =?, "
						+ "ds_apolice =?, vl_premio_total where id_usuario = ?");
		
		stmt.setLong(1, apolice.getIdVeiculo());
		stmt.setString(2, apolice.getNumeroApolice());
		stmt.setString(3, apolice.getNumeroEndosso());
		stmt.setString(4, apolice.getNumeroProposta());
		
		String dateFormated = simplesFormat.format(apolice.getDataInicioVigente());
		stmt.setString(5, dateFormated);
		dateFormated = simplesFormat.format(apolice.getDataFinalVigente());
		stmt.setString(6, dateFormated);
		
		stmt.setString(7, apolice.getDescricaoApolice());
		stmt.setDouble(8, apolice.getValorPremioTotal());
		stmt.setLong(9, apolice.getIdApolice());
		stmt.executeUpdate();
		stmt.close();

		return "Apolice Atualizado com Sucesso!";
	}

	// Select

	public List<Apolice> selecionar() throws SQLException, ParseException {
		List<Apolice> listaApolice = new ArrayList<Apolice>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_USUARIO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Apolice apolice = new Apolice();
			apolice.setIdApolice(rs.getLong(1));
			apolice.setIdVeiculo(rs.getLong(2));
			apolice.setNumeroApolice(rs.getString(3));
			apolice.setNumeroEndosso(rs.getString(4));
			apolice.setNumeroProposta(rs.getString(5));
			apolice.setDataInicioVigente(rs.getString(6));
			apolice.setDataFinalVigente(rs.getString(7));
			apolice.setDescricaoApolice(rs.getString(8));
			apolice.setValorPremioTotal(rs.getDouble(9));
			listaApolice.add(apolice);
		}

		return listaApolice;

	}
	
}
