package conexao.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) {
		
		String stringDeConexao = "jdbc:mysql://localhost";
		String usuario = "root";
		String senha = "admin";
		
		//O método getConnection lança uma exceção CHECADA, LOGO
		//PRECISA DE TRATAMENTO
		try {
			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
			System.out.println("Conectado!");
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
