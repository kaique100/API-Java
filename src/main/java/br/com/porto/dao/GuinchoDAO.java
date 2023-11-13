package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Guincho;
import br.com.porto.conexoes.ConexaoFactory;

public class GuinchoDAO {
	
	public Connection guinchAppConexao;

	public GuinchoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Guincho guincho) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_GUINCHO values(?,?,?,?,?,?)");
		stmt.setLong(1, guincho.getIdGuincho());
		stmt.setLong(2, guincho.getIdTipoGuincho());
		stmt.setString(3, guincho.getPlaca());
		stmt.setBoolean(4, guincho.isDisponibilidade());
		stmt.setString(5, guincho.getDescricaoGuincho());
		stmt.setString(6, guincho.getObservacaoGuincho());
		stmt.execute();
		stmt.close();
		return "Guincho cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_GUINCHO WHERE id_guincho = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Guincho Deletado com Sucesso!";
	}

	// Update
	public String atualizar(Guincho guincho) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_GUINCHO set id_tipo_guincho = ?,"
						+ "ds_placa =? , st_disponibilidade = ?, ds_guincho = ?, ob_guinhco = ?"
						+ "where id_guincho = ?");
		stmt.setLong(1, guincho.getIdTipoGuincho());
		stmt.setString(2, guincho.getPlaca());
		stmt.setBoolean(3, guincho.isDisponibilidade());
		stmt.setString(4, guincho.getDescricaoGuincho());
		stmt.setString(5, guincho.getObservacaoGuincho());
		stmt.setLong(6, guincho.getIdGuincho());
		stmt.executeUpdate();
		stmt.close();

		return "Guincho Atualizado com Sucesso!";
	}

	// Select

	public List<Guincho> selecionar() throws SQLException {
		List<Guincho> listaGuincho = new ArrayList<Guincho>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_GUINCHO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Guincho categoriaTarifaria = new Guincho();
			categoriaTarifaria.setIdGuincho(rs.getLong(1));
			categoriaTarifaria.setIdTipoGuincho(rs.getLong(2));
			categoriaTarifaria.setPlaca(rs.getString(3));
			categoriaTarifaria.setDisponibilidade(rs.getBoolean(4));
			categoriaTarifaria.setDescricaoGuincho(rs.getString(5));
			categoriaTarifaria.setObservacaoGuincho(rs.getString(6));
			listaGuincho.add(categoriaTarifaria);
		}

		return listaGuincho;

	}
	
}
