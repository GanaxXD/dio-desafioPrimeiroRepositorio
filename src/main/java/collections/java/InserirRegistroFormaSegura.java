package collections.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import conexao.bancodados.TesteConexao;

public class InserirRegistroFormaSegura {

	public static void main(String[] args) {

		// Para evitar o SQL INJECTION, eu uso a PreparedStatement
		// Que é a forma segura de pegar dados e inserir no banco
		try {
			Connection conexao = TesteConexao.getConnection();

			// 1: Pega os dados do usuário
			Scanner leitor = new Scanner(System.in);
			System.out.print("Digite o nome: ");
			String nome = leitor.nextLine();

			System.out.print("Digite o CPF: ");
			String cpf = leitor.nextLine();

			// 2: Prepara a SQL sem setar os valores aqui
			String sql = "INSERT INTO pessoas(nome, cpf) VALUES(?,?)";

			// 3: Faz a preparação do comando SQL por dentro, evitando ataque
			PreparedStatement pstm = conexao.prepareStatement(sql);

			// 4: Seta os valores inseridos na ordem mostrada na sql
			pstm.setString(1, nome);
			pstm.setString(2, cpf);

			// 5: Executa a sql segura
			pstm.execute();

			conexao.close();
			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
