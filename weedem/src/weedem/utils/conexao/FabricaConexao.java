package weedem.utils.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private Connection conexao;
	final private String host = "xxxxxxxxxxxxxxxxxxxxxxxx";
	final private String user = "xxxxxxxx";
	final private String passwd = "xxxxxxxxxxx";

	public Connection fazerConexao() {

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			this.conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/feedback?" + "user=" + user + "&password=" + passwd);
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
