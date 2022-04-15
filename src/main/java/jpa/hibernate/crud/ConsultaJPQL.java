package jpa.hibernate.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa.hibernate.models.umpraum.Usuario;

public class ConsultaJPQL {

	public static void main(String[] args) {
		
		//A obtenção será de vários usuários do banco

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");
		EntityManager em = emf.createEntityManager();
		
		//JPQL é uma pesquisa nos objetos, e não nos nomes das tabelas.
		//Dessa forma, a construção é feita com base na classe que se deseja
		//retornar. Tome cuidado, pois a query deve conter o nome da classe, e não da tabela
		String jpql = "select u from Usuario u"; //Seleciona todos os objetos da classe Usuário
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); //Faz a consulta, retornando objetos do tipo Usuário
		query.setMaxResults(5); //setando o máximo de retorno da busca, evitando que a aplicação quebre em casos muito grande de dados
		
		//Alocando os dados recebidos em uma Lista
		List<Usuario> usuarios = query.getResultList();
	
		//A alocação poderia ser feita em uma linha só:
		List<Usuario> usuarios2 = em.createQuery("select u from Usuario u", Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		usuarios.stream()
			.forEach(System.out::println);
		
		emf.close();
		em.close();
	}

}
