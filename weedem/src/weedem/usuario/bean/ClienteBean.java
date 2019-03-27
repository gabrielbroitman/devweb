package weedem.usuario.bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;


@ManagedBean
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	
	
	public ClienteBean()  {
		
	}

	
	
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
	
	public void gravar() throws SQLException {
		System.out.println("Salvando cliente: " + this.cliente.getNome() + " !");
		if(this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}
		
		
		new ClienteDAO().inserir(this.cliente);
		
		
	}

}
