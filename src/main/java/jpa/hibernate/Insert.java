package jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		
		//Essa f�brica cria Entity Managers.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");

		//Gerencia as Entidade. � quem faz o CRUD. Cada Gerente 
		//interage APENAS com um dialeto de um banco, ou seja, no mesmo projeto, 
		//um para Postgres,
		//outro para MySql...
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario("Pedro", "pedro@gmail.com");
		
		//Persistindo no DB: necess�rio estar dentro de uma transa��o.
		//Contudo, consultas n�o precisam de transa��o
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		System.out.println("O Id gerado no banco para o usu�rio foi: "+usuario.getId());
		
		em.close();
		emf.close();
	}

}
