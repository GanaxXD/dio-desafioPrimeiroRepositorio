package conexao.bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

//DAO ou Data Access Object é a classe responsável por fazer 
//o mapeamento dos dados relacionais de um objeto Java para o DB.
//É igual a função map() do Flutter para mapear o objeto dart para um "document" do Firebase.
//Ele já cria a conexão com o Banco de dados, e recebe os parâmetros que você quiser
//passar para realizar as consultas no Banco de dados.
//Geralmente não precisamos delas quando usamos ORMs como o Hibernate,
//Já que o mapeamento Objeto-Relacional é feito pelo próprio ORM 
public class DAO {

	private Connection conexao;

	// Inclui um registro no banco.
	// Retorna um int indicando o número 1 para sucesso em inserção de dados, e -1
	// para falha
	// Param: SQL e um array de Objetos chamado atriburos
	public int incluir(String sql, Object... atributos) {
		try {
			// PreparedStatement.RETURN_GENERATED_KEYS retorna os ids dos objetos gerados
			PreparedStatement pstm = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(pstm, atributos);

			if (pstm.executeUpdate() > 0) {
				ResultSet rs = pstm.getGeneratedKeys();
				if (rs.next()) {
					return rs.getInt(1);
				}
			}

			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// Adicionando atributos
	private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) {
		int indice = 0;
		for (Object atributo : atributos) {
			if (atributo instanceof String) {
				try {
					stmt.setString(indice, (String) atributo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (atributo instanceof Integer) {
				try {
					stmt.setInt(indice, (Integer) atributo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (atributo instanceof Double) {
				try {
					stmt.setDouble(indice, (Double) atributo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (atributo instanceof Boolean) {
				try {
					stmt.setBoolean(indice, (Boolean) atributo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (atributo instanceof Long) {
				try {
					stmt.setLong(indice, (Long) atributo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			indice++;
		}
	}

	// Criando conexão
	private Connection getConnection() {
		try {
			if (conexao != null && !conexao.isClosed())
				return conexao;
		} catch (Exception e) {
			e.printStackTrace();
		}

		conexao = TesteConexao.getConnection();
		return conexao;
	}
}
