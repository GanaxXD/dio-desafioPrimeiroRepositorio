package jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		
		//Essa fábrica cria Entity Managers.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");

		//Gerencia as Entidade. é quem faz o CRUD. Cada Gerente 
		//interage APENAS com um dialeto de um banco, ou seja, no mesmo projeto, 
		//um para Postgres,
		//outro para MySql...
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario("Pedro", "pedro@gmail.com");
		
		//Persistindo no DB: necessário estar dentro de uma transação.
		//Contudo, consultas não precisam de transação
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		System.out.println("O Id gerado no banco para o usuário foi: "+usuario.getId());
		
		em.close();
		emf.close();
	}

}
