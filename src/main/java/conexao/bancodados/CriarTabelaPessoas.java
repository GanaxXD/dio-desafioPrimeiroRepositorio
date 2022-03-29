package conexao.bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {

	public static void main(String[] args) {
		Connection conex�o = TesteConexao.getConnection();
		String sql = "CREATE TABLE IF NOT EXISTS pessoas("
				+ "id integer primary key not null auto_increment,"
				+ "nome varchar(200),"
				+ "cpf varchar(11)"
				+ ");";
		
		Statement stm;
		try {
			stm = conex�o.createStatement();
			stm.execute(sql);
			
			conex�o.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
