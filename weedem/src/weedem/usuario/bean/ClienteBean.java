package weedem.usuario.bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;


@ManagedBean
public class ClienteBean {
	
	private int id;
	private int cpf;
	private String nome;
	private String endereco;
	private String email;
	
	private Cliente cliente = new Cliente();
	
	public ClienteBean()  {
		
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
		System.out.println("Salvando cliente: " + this.cliente.getNome() + " !");
		if(this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
		
		
		new ClienteDAO().inserir(this.cliente);				
	}
	
	public void atualizar() throws SQLException {
		System.out.println("Atualizando cliente: " + this.cliente.getNome() + " !");
		if(this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
		
		
		new ClienteDAO().atualizar(this.cliente);				
	}

}
