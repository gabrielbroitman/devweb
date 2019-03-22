package weedem.usuario.servico;

import javax.faces.bean.ManagedBean;

import weedem.models.Cliente;

@ManagedBean
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String nome;
	
	public void gravar() {
		System.out.println("Salvando cliente: " + this.cliente.getNome() + " !");
		cliente = new Cliente();
	}

}
