package jpa.hibernate.testes;

import jpa.hibernate.infra.DAO;
import jpa.hibernate.models.umpramuitos.ItemPedido;
import jpa.hibernate.models.umpramuitos.Pedido;
import jpa.hibernate.models.umpraum.Produto;

public class TesteRelacioanmentoUmPraMuitos {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO();
		

		Pedido pedido = new Pedido();
		Produto produto = new Produto("Notebook", 2500.55);
		ItemPedido item = new ItemPedido(pedido, produto, 12);
		
		dao.abrirTransacao()
			.incluirNoBanco(produto)
			.incluirNoBanco(pedido)
			.incluirNoBanco(item)
			.fecharTransacao()
			.fecharConexao();
	}

}
