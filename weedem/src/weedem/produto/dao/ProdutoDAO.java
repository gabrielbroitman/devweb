package weedem.produto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weedem.models.Endereco;
import weedem.models.Produto;
import weedem.utils.conexao.FabricaConexao;

public class ProdutoDAO {

	FabricaConexao conexao;

	public ProdutoDAO() {
		this.conexao = new FabricaConexao();
	}

	public void Inserir(Produto produto) throws SQLException {
		String SQL = "insert into produto ( id_categoria, id_marca,nome_produto, descricao_produto, preco_produto) values (?, ?, ?, ?, ?)";

		Connection connector = this.conexao.fazerConexao();
		PreparedStatement ps = connector.prepareStatement(SQL);

		ps.setInt(1, produto.getCategoria().getId());
		ps.setInt(2, produto.getMarca().getId());
		ps.setString(3, produto.getNome());
		ps.setString(4, produto.getDescricao());
		ps.setDouble(5, produto.getPreco());

		ps.execute();

	}

	public List<Produto> listarTodos() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet rs = null;

		String SQL = "select id_produto, id_categoria, id_marca,nome_produto, descricao_produto, preco_produto from produto";

		Connection connector = this.conexao.fazerConexao();
		PreparedStatement ps = connector.prepareStatement(SQL);

		rs = ps.executeQuery();
		int i = 0;
		while (rs.next()) {

			Produto e = new Produto();
			e.setId(rs.getInt(1));
			e.setCategoria(rs.getInt(2));
			e.setMarca(rs.getInt(3));
			e.setNome(rs.getString(4));
			e.setDescricao(rs.getString(5));
			e.setPreco(rs.getDouble(6));

			produtos.add(e);
			i++;
		}

		return produtos;
	}

	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "delete from produto where id_produto = ?";

        Connection connector = this.conexao.fazerConexao();
		PreparedStatement ps = connector.prepareStatement(SQL);

		ps.setInt(1, _id);

		ps.execute();
		return true;
	}

	public Boolean Atualizar(Produto _objeto) throws SQLException {
		String sql = "UPDATE produto SET nome_produto = ?";
        sql += " WHERE id_produto = ?";
        Connection connector = this.conexao.fazerConexao();
		PreparedStatement ps = connector.prepareStatement(sql);
		ps.setString(1, _objeto.getNome());
		ps.setInt(2, _objeto.getId());
		         
        boolean rowUpdated = ps.executeUpdate() > 0;
        conexao.fecharConexao();
        return rowUpdated;     
	}

	public Produto buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;

		String SQL = "select id_produto, id_categoria, id_marca,nome_produto, descricao_produto, preco_produto from produto where id_produto = ?";

        Connection connector = this.conexao.fazerConexao();
		PreparedStatement ps = connector.prepareStatement(SQL);
		ps.setInt(1, _id);

		rs = ps.executeQuery();

		Produto p = null;
		if (rs.next()) {

			Produto e = new Produto();
			e.setId(rs.getInt(1));
			e.setCategoria(rs.getInt(2));
			e.setMarca(rs.getInt(3));
			e.setNome(rs.getString(4));
			e.setDescricao(rs.getString(5));
			e.setPreco(rs.getDouble(6));
		}

		return p;
	}

}