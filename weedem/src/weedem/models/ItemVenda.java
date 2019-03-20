package weedem.models;

import java.io.Serializable;

public class ItemVenda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int seq;
	private Venda venda;
	int codVenda;
	int codProduto;
	double precoProduto;
	int qtdProduto;
	
	public ItemVenda(int seq, int codVenda, int codProduto, int cpfCliente, double preco, int qtd) {
		super();
		this.seq = seq;
		this.codVenda = codVenda;
		this.codProduto = codProduto;
		this.precoProduto = preco;
		this.qtdProduto = qtd;
	}
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codProduto;
		result = prime * result + codVenda;
		long temp;
		temp = Double.doubleToLongBits(precoProduto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qtdProduto;
		result = prime * result + seq;
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		if (codProduto != other.codProduto)
			return false;
		if (codVenda != other.codVenda)
			return false;
		if (Double.doubleToLongBits(precoProduto) != Double.doubleToLongBits(other.precoProduto))
			return false;
		if (qtdProduto != other.qtdProduto)
			return false;
		if (seq != other.seq)
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
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
