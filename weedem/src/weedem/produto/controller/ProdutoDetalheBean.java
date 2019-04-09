package weedem.produto.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import weedem.models.Categoria;
import weedem.models.Marca;
import weedem.models.Produto;
import weedem.produto.dao.ProdutoDAO;
import weedem.usuario.dao.ClienteDAO;

@ManagedBean
public class ProdutoDetalheBean {

	private int id;
	private Categoria categoria;
	private Marca marca;
	private String nome;
	private String descricao;
	private double preco;
	
	private Produto produto = new Produto();

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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void buscarPorId(int id) throws SQLException {
		System.out.println("Buscando produto de id: " + id + " !");
		if (this.produto == null) {
			throw new RuntimeException("Cliente deve existir!");
		}

		this.produto = new ProdutoDAO().buscarPorId(id);
	}
	
	public void excluirProdutoPorId() throws SQLException {
		System.out.println("Excluindo produto de id: " + this.produto.getId() + " !");
		if (this.produto == null) {
			throw new RuntimeException("Produto deve existir!");
		}
		
		new ProdutoDAO().Excluir(this.produto.getId());
	}

}
