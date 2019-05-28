package weedem.usuario.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;

@ManagedBean
public class ClienteCadastroBean {

	private int id;
	private int cpf;
	private String nome;
	private String endereco;
	private String email;
	private ClienteDAO clienteDAO = new ClienteDAO();

	private Cliente cliente = new Cliente();

	public ClienteCadastroBean() {

	}

	public Cliente getCliente() {
		return cliente;
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

	public void gravar() throws SQLException {
		System.out.println("Salvando cliente: " + this.cliente.getNome());

		if (this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
		try {
			if (this.clienteDAO.buscarPorId(this.getId()) != null) {
				throw new RuntimeException("Cliente com esse id já existe.");
			}

			this.clienteDAO.inserir(this.cliente);
			System.out.println("Cliente salvo" + this.cliente.getNome() + "com sucesso!");

		} catch (Exception e) {
			throw e;
		}
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
