package weedem.utils.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			this.conexao = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/web_cam_20182, user, password)",
					"postgres",
					"postgrelasalle"
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.conexao;
	}
	
	public void fecharConexao() {
		
		try {
			
			this.conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

