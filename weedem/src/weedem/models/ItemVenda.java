package weedem.models;

import java.io.Serializable;

public class ItemVenda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int seq;
	private Venda venda;
	Produto produto;
	int qtdProduto;
	
	public ItemVenda() {
		
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public int getIdVenda() {
		return getIdVenda();
	}


	public Produto getProduto() {
		return produto;
	}
	
	public int getIdProduto() {
		return produto.getId();
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	
	


	
	
}
