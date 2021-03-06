package weedem.usuario.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;

@ManagedBean
@ViewScoped
public class ClienteDetalheBean {

	private int id;
	private int cpf;
	private String nome;
	private String endereco;
	private String email;
	private boolean pesquisado = false;
	private boolean excluido = false;
	private boolean falha = false;

	private Cliente cliente = new Cliente();
	private ClienteDAO clienteDAO = new ClienteDAO();

	public boolean isFalha() {
		return falha;
	}

	public void setFalha(boolean falha) {
		this.falha = falha;
	}

	public boolean getPesquisado() {
		return pesquisado;
	}

	public ClienteDetalheBean() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void buscarClientePorId() throws SQLException {
		this.excluido = false;
		System.out.println("Buscando cliente de id: " + this.id + " !");

		this.cliente = this.clienteDAO.buscarPorId(this.getId());

		if (this.cliente == null || this.getId() == 0) {
			this.pesquisado = false;
			this.falha = true;
		}

		if (this.cliente != null) {

			System.out.println(this.cliente.getNome());
			this.falha = false;
			this.pesquisado = true;

		}

	}

	public boolean excluirClientePorId() throws SQLException {
		System.out.println("Excluindo cliente de id: " + this.id + " !");
		if (this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}

		this.excluido = this.clienteDAO.excluir(this.getId());
		this.excluido = true;
		this.pesquisado = false;

		System.out.println("Exclus�o do cliente " + this.cliente.getNome() + " feita com sucesso? " + excluido);
		this.cliente = new Cliente();

		return excluido;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
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
