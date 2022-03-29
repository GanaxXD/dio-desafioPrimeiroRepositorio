package conexao.bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoDeDadosPeloJDBC {

	public static void main(String[] args) {
		//O m�todo getConnection lan�a uma exce��o CHECADA, LOGO
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
