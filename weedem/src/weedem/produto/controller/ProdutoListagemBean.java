package weedem.produto.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import weedem.models.Produto;
import weedem.models.Venda;
import weedem.produto.dao.ProdutoDAO;

@ManagedBean
@ViewScoped
public class ProdutoListagemBean {

	@Inject
	private Venda venda;

	private String nome = "";
	private String categoria = "";
	private ArrayList<String> categorias = new ArrayList<>();

	private int qtdProdutos = 0;

	private List<Produto> produtos = new ArrayList<>();
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	private boolean falha = false;
	private boolean pesquisado = false;

	public void listarProdutos() throws SQLException {
		System.out.println("Buscando produtos!");
		this.categorias.add("A");
		this.categorias.add("B");
		this.produtos = this.produtoDAO.listarTodos();
		this.qtdProdutos = this.produtos.size();

		System.out.println(this.produtos);

		if (this.produtos != null) {
			this.pesquisado = true;

			if (this.produtos == null) {
				this.falha = true;
				this.pesquisado = false;
				System.out.println("FALHA");
			}

			System.out.println("SUCESSO!");
		}

	}

	public void adicionarAoCarrinho(Produto produto, int qtd) {
		int i = 0;

		while (i < qtd && this.falha != true) {
			this.falha = !this.venda.adicionaItem(produto);
			i++;

		}

	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public String getNome() {
		return nome;
	}

	public ProdutoListagemBean() {

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<String> categoria) {
		this.categorias = categoria;
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
