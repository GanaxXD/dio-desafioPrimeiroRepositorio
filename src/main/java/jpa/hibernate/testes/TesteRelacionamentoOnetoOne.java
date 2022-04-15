package jpa.hibernate.testes;

import jpa.hibernate.infra.DAO;
import jpa.hibernate.models.umpraum.Assento;
import jpa.hibernate.models.umpraum.Cliente;
import jpa.hibernate.models.umpraum.Produto;

public class TesteRelacionamentoOnetoOne {

	public static void main(String[] args) {
		// Como na tabela de clientes eu tenho uma coluna para o 
		//id do assento, eu preciso primeiro persistir o assento
		//e depois o cliente
		
		DAO<Object> dao = new DAO(Object.class);
		
		/*
		 * Assento assento = new Assento("A2"); Cliente cliente = new Cliente("José",
		 * assento); Produto produto = new Produto("Caneta", 2.15);
		 * 
		 * dao.abrirTransacao()
			.incluirNoBanco(assento)
			.incluirNoBanco(cliente)
			.fecharTransacao()
			.fecharConexao();
		 */
		
		Assento assento = new Assento("A3");
		Cliente cliente = new Cliente("Francisca", assento);
		
		//Persistindo usando o cascade (ao incluir um cliente ele inclui sozinho no banco
		//o assento passado
		dao.abrirTransacao()
			.incluirNoBanco(cliente)
			.fecharTransacao()
			.fecharConexao();

	}

}
