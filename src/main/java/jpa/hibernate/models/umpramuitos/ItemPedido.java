package jpa.hibernate.models.umpramuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import jpa.hibernate.models.umpraum.Produto;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Muitos itens de pedido para um pedido
	@ManyToOne
	private Pedido pedido;
	
	//Muitos item de pedido para um produto
	//EAGER � o valor padr�o de qualquer fetch ...ToOne
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private Double preco; //O pre�o do produto pode mudar, mas o da compra finalizada, n�o.

	
	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemPedido(Pedido pedido, Produto produto, int quantidade, Double preco) {
		super();
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
		super();
		this.pedido = pedido;
		this.setProduto(produto);//j� adiciona o pre�o no itempedido
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		if(produto != null && this.preco == null) {
			this.setPreco(produto.getPreco());
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
