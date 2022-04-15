package jpa.hibernate.crud;

import java.sql.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.hibernate.models.umpraum.Usuario;

public class Select {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");
		EntityManager em = emf.createEntityManager();
		
		//O Select não precisa de transaction
		//O find() pede a classe da busca e o valor da chave primária da tupla que se deseja trazer
		Usuario usuario = em.find(Usuario.class, 1L);
		System.out.println(usuario);
		
		em.close();
		emf.close();
		
	}

}
