package weedem.models;

import java.io.Serializable;

public class ItemVenda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int seq;
	private Venda venda;
	int codVenda;
	int codProduto;
	int qtdProduto;
	
	public ItemVenda() {
		
	}
	
	public ItemVenda(int seq, int codVenda, int codProduto, int cpfCliente, double preco, int qtd) {
		super();
		this.seq = seq;
		this.codVenda = codVenda;
		this.codProduto = codProduto;

		this.qtdProduto = qtd;
	}

	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	
	
}
