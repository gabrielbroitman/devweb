package weedem.usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weedem.models.Cliente;

public class ClienteDAO implements ICliente {

	Connection conexao;
	
	public ClienteDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void inserir(Cliente _objeto) throws SQLException {

		String SQL = "insert into cliente (id, nome, email, cpf, matriculaCliente) values (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getEmail());
		ps.setString(4, _objeto.getCpf());
		
		ps.execute();
	}
	
//	public boolean updateBook(Book book) throws SQLException {
//        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
//        sql += " WHERE book_id = ?";
//        connect();
//         
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, book.getTitle());
//        statement.setString(2, book.getAuthor());
//        statement.setFloat(3, book.getPrice());
//        statement.setInt(4, book.getId());
//         
//        boolean rowUpdated = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowUpdated;     
//    }
	
	
	
	

	public Boolean excluir(int _id) throws SQLException {

		String SQL = "delete from cliente where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ps.execute();
		return true;
	}

	public Boolean atualizar(Cliente _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select id, nome, email, matriculaCliente from cliente where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		Cliente p = null;
		if (rs.next()) {
			
			p = new Cliente();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
		}
		
		return p;
	}

	public List<Cliente> listarTodos() throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs = null;
			
		String SQL = "select * from cliente";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			Cliente p = new Cliente();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
			p.setCpf(rs.getString(rs.getInt(4)));
			
			clientes.add(p);
		}
		
		return clientes;
	}


}
