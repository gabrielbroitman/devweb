package weedem.produto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weedem.models.Endereco;
import weedem.models.Produto;

public class ProdutoDAO {

	private Connection conexao;
	
	public ProdutoDAO(Connection conexao){
		this.conexao = conexao;
	}
	

	public void Inserir(Produto _objeto) throws SQLException {
	String SQL = "insert into produto (id, nome, preco, descricao) values (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setDouble(3, _objeto.getPreco());
		ps.setString(4, _objeto.getDescricao());
		
		ps.execute();
		
	}

	public List<Produto> listarTodos() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet rs = null;
		
		String SQL = "select * from produto";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		int i = 0;
		while (rs.next()) {
			
			Produto e = new Produto();
			e = (Produto) rs.getObject(i);
			
			produtos.add(e);
			i++;
		}
	
		return produtos;
	}

	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "delete from produto where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ps.execute();
		return true;
	}

	public Boolean Atualizar(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Produto buscarPorId(int _id) throws SQLException {
ResultSet rs = null;
		
		String SQL = "select id, nome, preco, descricao from produto where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		Produto p = null;
		if (rs.next()) {
			
			p = new Produto();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setPreco(rs.getDouble(3));
			p.setDescricao(rs.getString(4));
		}
		
		return p;
	}


	
}