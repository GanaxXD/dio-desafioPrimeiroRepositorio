package jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 1L);
		if(usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		emf.close();
		em.close();
	}

}
