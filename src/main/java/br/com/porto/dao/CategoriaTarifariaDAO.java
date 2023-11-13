package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.conexoes.ConexaoFactory;

public class CategoriaTarifariaDAO {

	
	public Connection guinchAppConexao;

	public CategoriaTarifariaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(CategoriaTarifaria categoriaTarifaria) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("INSERT INTO T_GPP_CATEGORIA_TARIFARIA values(?,?,?,?)");
		stmt.setLong(1, categoriaTarifaria.getIdCategoriaTarifaria());
		stmt.setString(2, categoriaTarifaria.getNumeroCategoriaTarifaria());
		stmt.setDouble(3, categoriaTarifaria.getValorBase());
		stmt.setDouble(4, categoriaTarifaria.getValorPesoMaximo());
		stmt.execute();
		stmt.close();
		return "Categoria Tarifaria cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("DELETE FROM T_GPP_CATEGORIA_TARIFARIA WHERE id_categoria_tarifaria = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Categoria Tarifaria Deletado com Sucesso!";
	}

	// Update
	public String atualizar(CategoriaTarifaria categoriaTarifaria) throws SQLException {
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_CATEGORIA_TARIFARIA set nm_categoria_tarifaria = ?,"
						+ "vl_base =? , vl_peso_maximo = ? where id_categoria_tarifaria = ?");
		stmt.setString(1, categoriaTarifaria.getNumeroCategoriaTarifaria());
		stmt.setDouble(2, categoriaTarifaria.getValorBase());
		stmt.setDouble(3, categoriaTarifaria.getValorPesoMaximo());
		stmt.setLong(4, categoriaTarifaria.getIdCategoriaTarifaria());
		stmt.executeUpdate();
		stmt.close();

		return "Categoria Tarifaria Atualizado com Sucesso!";
	}

	// Select

	public List<CategoriaTarifaria> selecionar() throws SQLException {
		List<CategoriaTarifaria> listaCategoriaTarifaria = new ArrayList<CategoriaTarifaria>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_CATEGORIA_TARIFARIA");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			CategoriaTarifaria categoriaTarifaria = new CategoriaTarifaria();
			categoriaTarifaria.setIdCategoriaTarifaria(rs.getLong(1));
			categoriaTarifaria.setNumeroCategoriaTarifaria(rs.getString(2));
			categoriaTarifaria.setValorBase(rs.getDouble(3));
			categoriaTarifaria.setValorPesoMaximo(rs.getDouble(4));
			listaCategoriaTarifaria.add(categoriaTarifaria);
		}

		return listaCategoriaTarifaria;

	}
	
}
