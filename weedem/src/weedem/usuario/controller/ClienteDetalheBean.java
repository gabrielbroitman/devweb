package weedem.usuario.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;

@ManagedBean
public class ClienteDetalheBean {

	private int id;
	private int cpf;
	private String nome;
	private String endereco;
	private String email;

	private Cliente cliente = new Cliente();

	public ClienteDetalheBean() {

	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void buscarClientePorId() throws SQLException {
		System.out.println("Buscando cliente de id: " + this.cliente.getId() + " !");
		if (this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
		
		this.cliente = new ClienteDAO().buscarPorId(this.getId());
		
	}
	
	public void excluirClientePorId() throws SQLException {
		System.out.println("Excluindo cliente de id: " + getId() + " !");
		if (this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
		
		new ClienteDAO().excluir(this.getId());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	
	

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
