package jpa.hibernate.models.umpramuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date data;

	//No server-side (banco de dados), eu não posso ter relacionamento
	//bidirecional, pois violaria suas regras. Mas para os casos onde
	//a regra de negócio pede um bidirecionamento, podemos mapear
	//no java sem registrar esse direcionamento no banco de dados.
	//NEste exemplo, o ideal é que na compra (itemPedido), eu tenha
	//as informações do pedido, por isso, no banco de dados na tabela
	//item pedido temos os ids dos pedidos. Mas pode ser que através
	//de um Pedido, eu queira ver quais itens estão relacionados.
	//Por isso, aqui, será criada essa propriedade com a anotação
	//mappedBy. Basta dizer qual o nome da variável que está refletindo
	//a relação entre o item pedido e o pedido (variável pedido da classe
	//ItemPedido.
	//
	//fetch diz se ele trará todos os itens de uma vez junto do pedido (eager)
	//ou lazy (preguisoço), trazendo somente quando eu preciso.
	//
	//Lazy é o valor padrão de qualquer fetch ...ToMAny
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<ItemPedido> itens;
	
	public Pedido() {
		this(new Date());
	}
	
	public Pedido(Date data) {
		super();
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
}
