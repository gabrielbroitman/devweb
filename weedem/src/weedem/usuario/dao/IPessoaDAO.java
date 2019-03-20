package weedem.usuario.dao;

import java.sql.SQLException;
import java.util.List;

import weedem.produtos.model.Pessoa;

public interface IPessoaDAO {
	void Inserir(Pessoa _objeto) throws SQLException;
	
	List<Pessoa> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Pessoa _objeto) throws SQLException;
	
	Pessoa buscarPorId(int _id) throws SQLException;
}
