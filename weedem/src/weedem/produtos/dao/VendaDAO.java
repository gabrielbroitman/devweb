package weedem.produtos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weedem.models.Endereco;
import weedem.models.ItemVenda;
import weedem.models.Venda;

public class VendaDAO {

	private Connection conexao;
	
	public VendaDAO(Connection conexao){
		this.conexao = conexao;
	}
	

	public void Inserir(Venda _objeto) throws SQLException {
		String SQL = "insert into venda (id, valorTotal, dataVenda, cpfCliente) values (?, ?, ?, ?)";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _objeto.getId());
		ps.setDouble(2, _objeto.getValorTotal());
		ps.setDate(3, _objeto.getDataVenda());
		ps.setInt(4, _objeto.getCpfCliente());

		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int idVenda = rs.getInt(1);
		int i = 0;
		
		for (ItemVenda iv : _objeto.getItens()) {
			SQL = "INSERT INTO ITEMVENDA (SEQ, CODVENDA, CODPRODUTO, PRECOPRODUTO, QTD) VALUES (?, ?, ?, ?, ?)";
			ps = conexao.prepareStatement(SQL);
			ps.setInt(1, i+1);
			ps.setInt(2, idVenda);
			ps.setInt(3, iv.getCodProduto());
			ps.setDouble(4, iv.getPrecoProduto());
			ps.setInt(5, iv.getQtdProduto());
			i++;
			ps.execute();
		}
		this.conexao.close();
	}

	public List<Venda> listarTodos() throws SQLException {
		List<Venda> vendas = new ArrayList<Venda>();
		ResultSet rs = null;

		String SQL = "select * from venda";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		rs = ps.executeQuery();
		int i = 0;
		while (rs.next()) {

			Venda e = new Venda();
			e = (Venda) rs.getObject(i);

			vendas.add(e);
			i++;
		}

		return vendas;
	}

	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "delete from venda where id = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setInt(1, _id);

		ps.execute();
		return true;
	}

	public Boolean Atualizar(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Venda buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;

		String SQL = "select * from venda where id = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);

		rs = ps.executeQuery();

		Venda p = null;
		if (rs.next()) {

			p = new Venda();

			p.setId(rs.getInt(1));
			p.setValorTotal(rs.getDouble(2));
			p.setDataVenda(rs.getDate(3));
			p.setCpfCliente(rs.getInt(4));
		}

		return p;
	}

}
