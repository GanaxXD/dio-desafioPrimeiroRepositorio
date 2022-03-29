package conexao.bancodados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RecuperandoDados {

	public static void main(String[] args) {
		try {
			Connection conexao = TesteConexao.getConnection();
			String sql = "SELECT * FROM pessoas";
			ResultSet rs;
			
			
			Statement stm = conexao.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("\tID: "+rs.getInt("id")+ "  - "
						+ "NOME: "+ rs.getString("nome")+ " - "
						+ "CPF: "+rs.getString("cpf")+ "\t|");
			}
			
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
