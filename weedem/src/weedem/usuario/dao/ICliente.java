package weedem.usuario.dao;


import java.sql.SQLException;
import java.util.List;

import weedem.models.Cliente;

public interface ICliente {

	void inserir(Cliente _objeto) throws SQLException;
	
	List<Cliente> listarTodos() throws SQLException;
	
	Boolean excluir(int _id) throws SQLException;
	
	Boolean atualizar(Cliente _objeto) throws SQLException;
	
	Cliente buscarPorId(int _id) throws SQLException;
}
