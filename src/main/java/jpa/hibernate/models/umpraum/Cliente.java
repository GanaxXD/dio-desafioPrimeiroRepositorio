package jpa.hibernate.models.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	//� mais l�gico eu saber pelo cliente em qual assento ele est�,
	//logo, o relacionamento fica no laco do cliente.
	//Al�m disso, para representar neste exemplo que o assento deve
	//ser de apenas um cliente, fechando ainda mais a 
	//representa��o 1x1, eu preciso inserir o @JoinColumn
	//indicando o nome da coluna que deve ser verificada
	//e indicando que ela deve ser �nica.
	//
	//O cascade � a propriedade que permite que ao incluir um 
	//cliente, o assento, mesmo n�o estando persistido no banco ainda,
	//Seja persistido na mesma transa��o.
	//Tem algumas op��es, como o ALL, onde a exclus�o de um cliente
	//ou a inser��o ou qualquer outra opera��o j� tratar� o assento
	//no bando. Usarei o PERSIST, que ocorer� apenas nas persistencias de um novo cliente
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "assento_id", unique = true)
	private Assento assento;

	
	
	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
	
	
}
