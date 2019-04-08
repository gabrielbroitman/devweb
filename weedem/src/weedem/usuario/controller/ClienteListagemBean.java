package weedem.usuario.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import weedem.models.Cliente;
import weedem.usuario.dao.ClienteDAO;

@ManagedBean
public class ClienteListagemBean {

	private List<Cliente> clientes;

	private Cliente cliente = new Cliente();

	public ClienteListagemBean() {

	}

	public Cliente getCliente() {
		return cliente;
	}


	public void listarClientes() throws SQLException {
		System.out.println("Buscando clientes!");
		if (this.cliente == null) {
			throw new RuntimeException("Cliente deve existir!");
		}

		this.clientes = new ClienteDAO().listarTodos();

	}

}
