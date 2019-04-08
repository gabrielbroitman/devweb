package weedem.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private double valorTotal;
	private Date dataVenda;
	private Cliente cliente;

	private List<ItemVenda> itens;
	private String situacao;
	
	public Venda(){}

	public Venda(int id, double valorTotal, Date dataVenda, Cliente cliente, List<ItemVenda> itens, String situacao) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.dataVenda = dataVenda;
		this.cliente = cliente;
		this.itens = itens;
		this.situacao = situacao;
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

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public int getQtdProdutos() {
		return this.getItens().size();
	}

}
