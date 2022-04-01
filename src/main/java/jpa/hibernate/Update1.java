package jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");
		EntityManager em = emf.createEntityManager();

		// Alterações, deleções e inserções precisam estar numa transaction
		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1L);
		System.out.println(usuario);

		usuario.setEmail("batman@gmail.com");
		usuario.setNome("Bruce");
		// Update é feito pelo merge()
		em.merge(usuario);

		em.getTransaction().commit();

		emf.close();
		em.close();
	}

}
