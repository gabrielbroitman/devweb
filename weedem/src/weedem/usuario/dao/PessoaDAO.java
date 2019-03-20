package weedem.usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weedem.usuario.model.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	Connection conexao;
	
	public PessoaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		
		String SQL = "insert into pessoa (id, nome, email) values (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getEmail());
		
		ps.execute();
	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, email from pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			Pessoa p = new Pessoa();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
			
			pessoas.add(p);
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "select id, nome, email from pessoa where id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		Pessoa p = null;
		if (rs.next()) {
			
			p = new Pessoa();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
		}
		
		return p;
	}

}