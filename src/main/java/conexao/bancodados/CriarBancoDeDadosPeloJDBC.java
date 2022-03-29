package conexao.bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoDeDadosPeloJDBC {

	public static void main(String[] args) {
		//O método getConnection lança uma exceção CHECADA, LOGO
		//PRECISA DE TRATAMENTO
		try {
			Connection conexao = TesteConexao.getConnection();			
			//Criando o banco pelo JDBC
			Statement stm = conexao.createStatement();
			stm.execute("CREATE DATABASE IF NOT EXISTS teste_java");
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
