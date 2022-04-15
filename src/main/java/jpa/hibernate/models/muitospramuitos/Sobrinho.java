package jpa.hibernate.models.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sobrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	//LEMBRE-SE:
	//No BD só podemos ter o relacionamento unidirecional. Não
	//faz sentido ter o id em ambas as tabelas que se relacionam
	//(ex: tabela tio = sobrinho_id; tabela sobrionho = tio_id)
	//Para isso, criamos uma outra tabela com as linações NXM.
	//Nesse exmplo, o relaconamento ficará apontado pela tabela tio,
	//Logo, esta PRECISA ter o mappedBy para indicar
	//ao hibernate que a nova tabela no BD representando o MxN
	//terá primeiro o nome da tabela tio, depois a do sobrinho
	@ManyToMany(mappedBy = "sobrinhos")
	private List<Tio> tios = new ArrayList<>();
	
	public Sobrinho(String nome) {
		super();
		this.nome = nome;
	}


	public Sobrinho() {
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


	public List<Tio> getTios() {
		return tios;
	}


	public void setTios(List<Tio> tios) {
		this.tios = tios;
	}
	
	
	
}
