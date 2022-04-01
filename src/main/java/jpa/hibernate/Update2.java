package jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update2 {

	// Nesse exemplo, testamos o ESTADO GERENCIADO DOS OBJETOS que o JPA realiza.
	// Estado Gerenciado sempre ocorre quando um objeto foi localizado (pego do
	// bano)
	// dentro da transaction. Se você criar um objeto com dados vindo do front, ele
	// não entra no estado gerenciado.
	// iniciada (depois da getTransaction.begin()). Nesse caso, o objeto dentro
	// da transação terá suas alterações, se feitas, refletidas no banco, mesmo não
	// chamando explicitamente o método merge.
	// Para que isso não ocorra, é necessário deixar o objeto fora
	// do estado de gerenciamento do JPA.
	//
	//
	// Para não deixá-lo gerenciado, basta indicar ao JPA usando o método
	// detach(nome_do_objeto) do EntityManager criado.
	// Desta forma, as alterações no objeto só serão refletidas no banco se houver
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

		// Alterações, deleções e inserções precisam estar numa transaction
		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1L);
		System.out.println(usuario);

		usuario.setEmail("batman@gmail.com");
		usuario.setNome("Bruce Wayne");
		// Update é feito pelo merge()
		// em.merge(usuario);
		// NOTA: mesmo que o merge esteja comentado, a alteração será feita,
		// por conta do estado gerenciado

		em.getTransaction().commit();

		emf.close();
		em.close();
	}

}
