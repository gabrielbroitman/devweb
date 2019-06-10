package weedem.produtos.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import weedem.models.Produto;
import weedem.models.Venda;
import weedem.produto.dao.ProdutoDAO;

@ManagedBean
public class ProdutoListagemBean {

	@Inject
	private Venda venda;
	
	private String nome;
	private String categoria;

	private int qtdProdutos = 0;

	private List<Produto> produtos = new ArrayList<>();
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	private boolean falha = false;
	private boolean pesquisado = false;

	public void listarProdutos() throws SQLException {
		System.out.println("Buscando produtos!");

		// this.produtos = this.produtoDAO.listarTodos();
		this.qtdProdutos = this.produtos.size();
		Produto p = new Produto();
		p.setNome("öi");
		this.produtos.add(p);
		if (this.produtos != null) {
			this.pesquisado = true;

			if (this.produtos == null || this.produtos.isEmpty() || this.nome.equals("Gabriel")) {
				this.falha = true;
				this.pesquisado = false;
			}
		}

	}

	public void adicionarAoCarrinho(Produto produto, int qtd) {
		int i = 0;

		while (i < qtd && this.falha != true) {
			this.falha = !this.venda.adicionaItem(produto);
			i++;

		}

	}

	public String getNome() {
		return nome;
	}

	public ProdutoListagemBean() {
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean isFalha() {
		return falha;
	}

	public void setFalha(boolean falha) {
		this.falha = falha;
	}

	public boolean isPesquisado() {
		return pesquisado;
	}

	public void setPesquisado(boolean pesquisado) {
		this.pesquisado = pesquisado;
	}

}
