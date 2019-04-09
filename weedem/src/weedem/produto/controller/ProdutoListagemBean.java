package weedem.produto.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import weedem.models.Produto;
import weedem.produto.dao.ProdutoDAO;

@ManagedBean
public class ProdutoListagemBean {
	
	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void listarProdutos() throws SQLException {
		System.out.println("Buscando produtos!");

		this.produtos = new ProdutoDAO().listarTodos();

		if (this.produtos == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
	}

}
