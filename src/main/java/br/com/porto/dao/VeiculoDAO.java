package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.porto.beans.Veiculo;
import br.com.porto.conexoes.ConexaoFactory;

public class VeiculoDAO {

	public Connection guinchAppConexao;

	public VeiculoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}

	// Insert

	public String insert(Veiculo veiculo) throws SQLException {

		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);

		PreparedStatement stmt = guinchAppConexao
				.prepareStatement("INSERT INTO T_GPP_VEICULO values(?,?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setLong(1, veiculo.getIdVeiculo());
		stmt.setLong(2, veiculo.getIdCategoriaTarifaria());
		stmt.setLong(3, veiculo.getIdCliente());
		stmt.setString(4, veiculo.getMarca());
		stmt.setString(5, veiculo.getModelo());
		
		String dateFormated = simplesFormat.format(veiculo.getFabricacao());
		stmt.setString(6, dateFormated);
		
		stmt.setString(7, veiculo.getChassi());
		stmt.setString(8, veiculo.getPlaca());
		stmt.setString(9, veiculo.getCor());
		stmt.setString(10, veiculo.getCombustivel());
		stmt.setString(11, veiculo.getTransmissao());
		stmt.setDouble(12, veiculo.getQuilometragem());
		
		stmt.execute();
		stmt.close();
		return "Veiculo cadastrado com Sucesso!!!";
	}

	// Delete

	public String deletar(Long id) throws SQLException {

		PreparedStatement stmt = guinchAppConexao.prepareStatement("DELETE FROM T_GPP_VEICULO WHERE id_veiculo = ?");

		stmt.setLong(1, id);
		stmt.executeUpdate();
		stmt.close();

		return "Veiculo Deletado com Sucesso!";
	}

	// Update

	public String atualizar(Veiculo veiculo) throws SQLException {
		
		String format = "dd/MM/yyyy";
		SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
		
		PreparedStatement stmt = guinchAppConexao
				.prepareStatement(" Update T_GPP_VEICULO set id_categoria_tarifaria = ?, id_cliente = ?, ds_marca = ?, "
						+ "ds_modelo = ?, dt_fabricacao = ?, nr_chassi = ?, ds_placa = ?, "
						+ "ds_cor = ?, ds_combustivel =?, ds_transmissao =?, nr_quilometragem =? where id_veiculo = ?");
		stmt.setLong(1, veiculo.getIdCategoriaTarifaria());
		stmt.setLong(2, veiculo.getIdCliente());
		stmt.setString(3, veiculo.getMarca());
		stmt.setString(4, veiculo.getModelo());
		
		String dateFormated = simplesFormat.format(veiculo.getFabricacao());
		stmt.setString(5, dateFormated);
		
		stmt.setString(6, veiculo.getChassi());
		stmt.setString(7, veiculo.getPlaca());
		stmt.setString(8, veiculo.getCor());
		stmt.setString(9, veiculo.getCombustivel());
		stmt.setString(10, veiculo.getTransmissao());
		stmt.setDouble(11, veiculo.getQuilometragem());
		stmt.setLong(12, veiculo.getIdVeiculo());
		stmt.executeUpdate();
		stmt.close();

		return "Veiculo Atualizado com Sucesso!";
	}

	// Select

	public List<Veiculo> selecionar() throws SQLException, ParseException {
		List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
		PreparedStatement stmt = guinchAppConexao.prepareStatement("SELECT * FROM T_GPP_VEICULO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Veiculo veiculo = new Veiculo();
			veiculo.setIdVeiculo(rs.getLong(1));
			veiculo.setIdCategoriaTarifaria(rs.getLong(2));
			veiculo.setIdCliente(rs.getLong(3));
			veiculo.setMarca(rs.getString(4));
			veiculo.setModelo(rs.getString(5));
			veiculo.setFabricacao(rs.getString(6));
			veiculo.setChassi(rs.getString(7));
			veiculo.setPlaca(rs.getString(8));
			veiculo.setCor(rs.getString(9));
			veiculo.setCombustivel(rs.getString(10));
			veiculo.setTransmissao(rs.getString(11));
			veiculo.setQuilometragem(rs.getDouble(12));
			listaVeiculo.add(veiculo);
		}
		
		return listaVeiculo;

	}
	
}
