package weedem.models;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private double valorTotal;
	private Date dataVenda;
	private int cpfCliente;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpfCliente;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + id;
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Venda other = (Venda) obj;
		if (cpfCliente != other.cpfCliente)
			return false;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (id != other.id)
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}
	private List<ItemVenda> itens;
	private String situacao;
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Venda() {
		
	}
	
	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public Venda(int id, double valorTotal, Date dataVenda, int cpfCliente, List<ItemVenda> itens) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.dataVenda = dataVenda;
		this.cpfCliente = cpfCliente;
		this.itens = itens;
		this.situacao = "não finalizada";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date date) {
		this.dataVenda = date;
	}
	public int getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(int cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
}

