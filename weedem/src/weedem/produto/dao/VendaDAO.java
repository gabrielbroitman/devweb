package weedem.produto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weedem.models.Endereco;
import weedem.models.ItemVenda;
import weedem.models.Venda;
import weedem.usuario.dao.ClienteDAO;

public class VendaDAO {

	private Connection conexao;
	
	private ClienteDAO clienteDAO;
	
	public VendaDAO(Connection conexao){
		this.conexao = conexao;
	}
	

	public void Inserir(Venda _objeto) throws SQLException {
		String SQL = "insert into venda (data_venda, total_venda, id_cliente, qtd_venda) values (?, ?, ?, ?)";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setDate(1, _objeto.getDataVenda());
		ps.setDouble(2, _objeto.getValorTotal());
		ps.setInt(3, _objeto.getCliente().getId());
		ps.setInt(4, _objeto.getQtdProdutos());

		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int idVenda = rs.getInt(1);
		int i = 0;
		
		for (ItemVenda iv : _objeto.getItens()) {
			SQL = "INSERT INTO ITEMVENDA (id_venda, id_produto, qtd) VALUES (?, ?, ?)";
			ps = conexao.prepareStatement(SQL);
			ps.setInt(1, idVenda);
			ps.setInt(2, iv.getCodProduto());
			ps.setInt(3, iv.getQtdProduto());

			i++;
			ps.execute();
		}
		this.conexao.close();
	}

	public List<Venda> listarTodos() throws SQLException {
		List<Venda> vendas = new ArrayList<Venda>();
		ResultSet rs = null;

		String SQL = "select id_venda, data_venda, total_venda, id_cliente, qtd_venda from venda";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		rs = ps.executeQuery();
		int i = 0;
		while (rs.next()) {

			Venda e = new Venda();
			e.setId(rs.getInt(1));
			e.setDataVenda(rs.getDate(2));
			e.setValorTotal(rs.getInt(3));
			e.setCliente(this.clienteDAO.buscarPorId(rs.getInt(4)));
			SQL = "select id_venda, id_produto, qtd from ITEMVENDA where id_venda = ?";
			PreparedStatement ps2 = conexao.prepareStatement(SQL);
			ps2.setInt(1, e.getId());
			ResultSet rs2 = ps.executeQuery();
			List<ItemVenda> itens = new ArrayList<>();
			while (rs2.next()) {
				ItemVenda iv = new ItemVenda();
				iv.setVenda(venda);
				
				itens.add(itemVenda);			
			}
			// e.setSituacao(rs.getInt(5));
		
			

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
