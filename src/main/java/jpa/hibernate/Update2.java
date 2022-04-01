package jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update2 {

	// Nesse exemplo, testamos o ESTADO GERENCIADO DOS OBJETOS que o JPA realiza.
	// Estado Gerenciado sempre ocorre quando um objeto foi localizado (pego do
	// bano)
	// dentro da transaction. Se voc� criar um objeto com dados vindo do front, ele
	// n�o entra no estado gerenciado.
	// iniciada (depois da getTransaction.begin()). Nesse caso, o objeto dentro
	// da transa��o ter� suas altera��es, se feitas, refletidas no banco, mesmo n�o
	// chamando explicitamente o m�todo merge.
	// Para que isso n�o ocorra, � necess�rio deixar o objeto fora
	// do estado de gerenciamento do JPA.
	//
	//
	// Para n�o deix�-lo gerenciado, basta indicar ao JPA usando o m�todo
	// detach(nome_do_objeto) do EntityManager criado.
	// Desta forma, as altera��es no objeto s� ser�o refletidas no banco se houver
	// a chamada explicita do merge()
	//
	//
	// Ex.:
	// em.getTransaction().begin();
	//
	// Usuario usuario = em.find(Usuario.class, 1L);
	// em.detach(usuario);
	//
	// usuario.setEmail("batman@gmail.com");
	// usuario.setNome("Bruce Wayne");
	//
	// em.getTransaction().commit();
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpahibernate");
		EntityManager em = emf.createEntityManager();

		// Altera��es, dele��es e inser��es precisam estar numa transaction
		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1L);
		System.out.println(usuario);

		usuario.setEmail("batman@gmail.com");
		usuario.setNome("Bruce Wayne");
		// Update � feito pelo merge()
		// em.merge(usuario);
		// NOTA: mesmo que o merge esteja comentado, a altera��o ser� feita,
		// por conta do estado gerenciado

		em.getTransaction().commit();

		emf.close();
		em.close();
	}

}
