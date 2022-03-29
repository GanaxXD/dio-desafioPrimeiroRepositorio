package conexao.bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RecuperandoDadosComLike {

	public static void main(String[] args) {
		try {
			Connection conexao = TesteConexao.getConnection();
			Connection con = TesteConexao.getConexaoPeloProperties();
			Scanner leitor = new Scanner(System.in);
			
			System.out.print("Digite o nome: ");
			String complemento = leitor.nextLine();
			
			String sql = "SELECT * FROM pessoas WHERE nome LIKE ? ";
			ResultSet rs;
			
			
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, "%" + complemento + "%");
			rs = stm.executeQuery();
			
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
