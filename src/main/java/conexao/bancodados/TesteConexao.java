package conexao.bancodados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TesteConexao {

	public static Connection getConnection() {
		// O método getConnection lança uma exceção CHECADA, LOGO
		// PRECISA DE TRATAMENTO
		try {
			String stringDeConexao = "jdbc:mysql://localhost:3306/teste_java";
			String usuario = "root";
			String senha = "admin";

			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Criando conexão com os dados do .properties
	public static Connection getConexaoPeloProperties() {
		// O método getConnection lança uma exceção CHECADA, LOGO
		// PRECISA DE TRATAMENTO
		try {
			Properties prop = getProperties();
			String stringDeConexao = prop.getProperty("banco.url");
			String usuario = prop.getProperty("banco.usuario");
			String senha = prop.getProperty("banco.senha");

			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
			return conexao;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Consumindo os dados dos arquivos .properties
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();

		String caminho = "/conexao.properties";
		prop.load(TesteConexao.class.getResourceAsStream(caminho));
		return prop;
	}

}
