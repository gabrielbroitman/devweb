package weedem.produto.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import weedem.models.Categoria;
import weedem.models.Marca;
import weedem.models.Produto;
import weedem.models.Venda;
import weedem.produto.dao.ProdutoDAO;

@ManagedBean
public class ProdutoDetalheBean {

	private int id;
	private Categoria categoria;
	private Marca marca;
	private String nome;
	private String descricao;
	private double preco;

	private Produto produto;

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	private boolean falha = false;
	private boolean pesquisado = false;
	
	@Inject
	private Venda venda;

	public void adicionarAoCarrinho(Produto produto, int qtd) {
		int i = 0;

		while (i < qtd && this.falha != true) {
			this.falha = !this.venda.adicionaItem(produto);
			i++;

		}
	}
	
	public void buscarProdutoPorId() throws SQLException {
		this.produto = this.produtoDAO.buscarPorId(this.id);
		
		if (this.produto != null) {
			this.pesquisado = true;
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
