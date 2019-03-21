package weedem.utils.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private Connection conexao;
	//final private String host = "localhost:3306/weedem";
	//final private String user = "root";
	//final private String passwd = "admin";

	public Connection fazerConexao() throws SQLException {
		if (this.conexao == null || this.conexao.isClosed()) {
			try {
	
				// This will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");
	
				// Setup the connection with the DB
				this.conexao = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/weedem","root","admin");  
			} catch (Exception e) {
				e.printStackTrace();
			}
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
